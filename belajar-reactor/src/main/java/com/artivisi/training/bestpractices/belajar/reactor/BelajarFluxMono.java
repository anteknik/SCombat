package com.artivisi.training.bestpractices.belajar.reactor;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BelajarFluxMono {
    public static void main(String[] args) {
        //simpleFlux();
        //backpressure();
        gabunganMono();
    }

    public static void simpleFlux() {
        List<Integer> hasil = new ArrayList<>();

        Flux.just(1, 2, 3, 4)
                .log()
                .filter(i -> i%2 == 0)
                .subscribe(hasil::add);

        hasil.stream().forEach(System.out::println);
    }

    public static void backpressure() {
        List<Integer> hasil = new ArrayList<>();

        Flux.just(1, 2, 3, 4, 5, 6, 7, 8, 9)
                .log()
                .subscribe(new Subscriber<Integer>() {

                    private Integer paging = 3;
                    private Subscription subscription;
                    private Integer counter = 0;

                    @Override
                    public void onSubscribe(Subscription s) {
                        System.out.println("On Subscribe dijalankan");
                        this.subscription = s;
                        subscription.request(paging);
                    }

                    @Override
                    public void onNext(Integer data) {
                        hasil.add(data);
                        counter++;
                        if(counter % paging == 0){
                            subscription.request(paging);
                        }
                    }

                    @Override
                    public void onError(Throwable t) {
                        t.printStackTrace();
                    }

                    @Override
                    public void onComplete() {
                        System.out.println("Semua data sudah dikirim");
                    }
                });

        hasil.stream().forEach(System.out::println);
    }

    public static void gabunganMono() {

        Mono<String> mNama = Mono.just("Endy");
        Mono<LocalDate> mWaktuTransaksi = Mono.just(LocalDate.now());
        Mono<BigDecimal> mNilaiTransaksi = Mono.just(new BigDecimal("100000"));

        Mono<Transaksi> gabungan =
                Mono.zip((data) ->  createTransaksi(data),
                        mNama, mWaktuTransaksi, mNilaiTransaksi);

        gabungan.subscribe(data -> tampilkanTransaksi(data));


    }

    private static void tampilkanTransaksi(Transaksi data) {
        System.out.println("Nama : "+data.getNama());
        System.out.println("waktuTransaksi : "+data.getTanggal());
        System.out.println("nilaiTransaksi : "+data.getNilai());
    }

    private static Transaksi createTransaksi(Object[] data) {
        Transaksi t = new Transaksi();
        t.setNama((String) data[0]);
        t.setTanggal((LocalDate) data[1]);
        t.setNilai((BigDecimal) data[2]);
        return t;
    }
}

class Transaksi {
    private String nama;
    private LocalDate tanggal;
    private BigDecimal nilai;

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public LocalDate getTanggal() {
        return tanggal;
    }

    public void setTanggal(LocalDate tanggal) {
        this.tanggal = tanggal;
    }

    public BigDecimal getNilai() {
        return nilai;
    }

    public void setNilai(BigDecimal nilai) {
        this.nilai = nilai;
    }
}
