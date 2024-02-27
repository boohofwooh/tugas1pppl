package org.example;

import java.util.ArrayList;

public class Wallet {
    String owner;
    ArrayList<String> listKartu;
    ArrayList<Integer> listUangKoin;
    ArrayList<Integer> listUangLembaran;


    public Wallet(String owner) {
        this.owner = owner;
        listKartu = new ArrayList<>();
        listUangKoin = new ArrayList<>();
        listUangLembaran = new ArrayList<>();
    }

    public String setOwner(){
        return owner;
    }

    public void tambahKartu(String namaKartu){
        this.listKartu.add(namaKartu);
    }

    public String ambilKartu(String namaKartu){
        boolean kartuDiambil = this.listKartu.remove(namaKartu);
        if (kartuDiambil){
            return namaKartu;
        }
        throw new Error("kartu belum ditambahkan ke dompet");
    }

    public void tambahUangRupiah(int jumlahUang){
        if (jumlahUang < 0){
            throw new Error("uang tidak boleh minus");
        }

        if (jumlahUang >= 1000){
            listUangLembaran.add(jumlahUang);
        } else {
            listUangKoin.add(jumlahUang);
        }
    }

    public int ambilUang(int jumlahUang){
        boolean uangLembaranDiambil = this.listUangLembaran.remove(
                Integer.valueOf(jumlahUang));
        if (uangLembaranDiambil){
            return jumlahUang;
        }
        boolean uangKoinDiambil = this.listUangKoin.remove(
                Integer.valueOf(jumlahUang));
        if (uangKoinDiambil){
            return jumlahUang;
        }
        return 0;
    }

    public int tampilkanUang(){
        int totalUang = 0;
        for (Integer uang: listUangKoin){
            totalUang += uang;
        }
        for (Integer uang: listUangLembaran){
            totalUang += uang;
        }
        return totalUang;
    }
}
