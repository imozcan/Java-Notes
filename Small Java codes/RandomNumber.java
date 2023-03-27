
/*----------------------------------------------------------------------------------------------------------------------
    0-99 arası toplam 20 adet random sayı üretiliyor. bu üretilen sayıların ilk 10 ve ikinci 10 olmak üzere aynı sırada ve 
     aynı sayıların gelme ihtimali
    örnek
    grup 1:   15 22 35 48 56 5 65 8 3 84
    grup 2:   15 22 35 48 56 5 65 8 3 84
     
----------------------------------------------------------------------------------------------------------------------*/





package csd;

import java.util.Random;

public class App {
    public static void main(String[] args) {
        Router.run();
    }
}

class Router {
    public static void run() {
        Random r = new Random();
        Foo foo = new Foo();
        foo.run(r);
    }
}

class Foo {
    public int a, b, c, d, e, f, g, h, j, k;
    public int a2, b2, c2, d2, e2, f2, g2, h2, j2, k2;
    public long count, count2, count3;
    public boolean flag;

    public void run(Random r) {
        long majorCountIncrease = 1_000_000_000L;

        while (true) {
            if (count < 0) {
                ++count2;
                count = 0;
            }

            if (count2 < 0) {
                ++count3;
                count2 = 0;
            }

            if (count == majorCountIncrease) {
                System.out.printf("Count: %d %n", count);
                majorCountIncrease += 1_000_000_000L;
            }

            ++count;

            a = r.nextInt(100);
            a2 = r.nextInt(100);
            if (a != a2)
                continue;
            b = r.nextInt(100);
            b2 = r.nextInt(100);
            if (b != b2)
                continue;
            c = r.nextInt(100);
            c2 = r.nextInt(100);
            if (c != c2)
                continue;
            d = r.nextInt(100);
            d2 = r.nextInt(100);
            if (d != d2)
                continue;
            e = r.nextInt(100);
            e2 = r.nextInt(100);
            if (e != e2)
                continue;
            f = r.nextInt(100);
            f2 = r.nextInt(100);
            if (f != f2)
                continue;
            g = r.nextInt(100);
            g2 = r.nextInt(100);
            if (g != g2)
                continue;
            h = r.nextInt(100);
            h2 = r.nextInt(100);
            if (h != h2)
                continue;
            j = r.nextInt(100);
            j2 = r.nextInt(100);
            if (j != j2)
                continue;
            k = r.nextInt(100);
            k2 = r.nextInt(100);
            if (k != k2)
                continue;

            flag = !flag;

            if (flag) {
                System.out.printf("Rastgele üretilen ilk dizinin elemanları    : %d %d %d %d %d %d %d %d %d %d%n", a, b, c, d, e, f, g, h, j, k);
                System.out.printf("Rastgele üretilen ikinci dizinin elemanları : %d %d %d %d %d %d %d %d %d %d%n", a2, b2, c2, d2, e2, f2, g2, h2, j2, k2);
                System.out.printf("Count: %d %n", count);

                if (count2 != 0L)
                    System.out.printf("Count2: %d %n", count2);
                if (count3 != 0L)
                	System.out.printf("Count2: %d %n", count2);
                
            }
        }
    }
}

