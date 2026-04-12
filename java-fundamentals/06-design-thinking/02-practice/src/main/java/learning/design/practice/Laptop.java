package learning.design.practice;

/*
 * Design practice — this file (Laptop.java)
 *
 * Model composition (HAS-A), not inheritance from Cpu or Disk.
 *
 * 1) Add two private final fields: one Cpu, one Disk.
 * 2) Constructor Laptop(Cpu cpu, Disk disk) — assign both fields.
 * 3) Method void boot():
 *    - Call tick() on the Cpu field.
 *    - Call report() on the Disk field.
 *    - Print exactly one line: laptop booted
 *
 * Do not extend Cpu or Disk; the laptop owns them and delegates.
 */
public class Laptop {

    // TODO fields (Cpu + Disk)
    private final Cpu cpu;
    private final Disk disk;

    public Laptop(Cpu cpu, Disk disk) {
        // TODO
        this.cpu = cpu;
        this.disk = disk;
    }

    public void boot() {
        // TODO
        cpu.tick();
        disk.report();
        System.out.println("laptop booted");
    }
}
