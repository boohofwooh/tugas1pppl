package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class WalletTest {
    Wallet wallet = new Wallet("jamal");
    @Test
    void testSetOwner() {
        Assertions.assertEquals("jamal", wallet.setOwner());
    }

    @Test
    void testTambahKartu() {
        wallet.tambahKartu("emoney");
        wallet.tambahKartu("atm");

        Assertions.assertTrue(wallet.listKartu.contains("atm"));
        System.out.println(wallet.listKartu);
    }

    @Test
    void testAmbilKartu() {
        wallet.tambahKartu("ktp");
        wallet.tambahKartu("sim");
        String kartuDiambil = wallet.ambilKartu("ktp");

        Assertions.assertEquals("ktp",kartuDiambil);
    }

    @Test
    void testTambahUangRupiah() {
        wallet.tambahUangRupiah(1000);
        wallet.tambahUangRupiah(200);

        Assertions.assertAll(
                () -> Assertions.assertTrue(wallet.listUangLembaran.contains(1000)),
                () -> Assertions.assertTrue(wallet.listUangKoin.contains(200))
        );
    }

    @Test
    void testAmbilUang() {
        wallet.tambahUangRupiah(1000);
        wallet.tambahUangRupiah(500);

        Assertions.assertAll(
                () -> Assertions.assertEquals(500,wallet.ambilUang(500)),
                () -> Assertions.assertEquals(1000,wallet.ambilUang(1000))
        );
    }

    @Test
    void testTampilkanUang() {
        wallet.tambahUangRupiah(15000);
        wallet.tambahUangRupiah(700);

        Assertions.assertEquals(15700, wallet.tampilkanUang());
    }
}