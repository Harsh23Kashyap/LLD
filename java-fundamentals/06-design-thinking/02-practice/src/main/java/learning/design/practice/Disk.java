package learning.design.practice;

/*
 * Design practice — this file (Disk.java)
 *
 * Provided as-is. Laptop will hold a reference to a Disk and ask it for size during boot().
 */
public class Disk {

    private final int gigabytes;

    public Disk(int gigabytes) {
        this.gigabytes = gigabytes;
    }

    public void report() {
        System.out.println("disk " + gigabytes + " GB");
    }
}
