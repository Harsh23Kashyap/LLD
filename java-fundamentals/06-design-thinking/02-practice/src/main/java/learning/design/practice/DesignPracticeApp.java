package learning.design.practice;

/*
 * Design practice — this file (DesignPracticeApp.java)
 *
 * In main:
 * 1) new Cpu()
 * 2) new Disk(512)
 * 3) new Laptop(cpu, disk)
 * 4) Call boot() on the laptop.
 *
 * Expected output exactly:
 * cpu tick
 * disk 512 GB
 * laptop booted
 */
public final class DesignPracticeApp {

    private DesignPracticeApp() {
    }

    public static void main(String[] args) {
        // TODO wire Cpu, Disk, Laptop and call boot()
        Cpu cpu = new Cpu();
        Disk disk = new Disk(512);
        Laptop laptop = new Laptop(cpu, disk);
        laptop.boot();
    }
}
