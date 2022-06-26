package bookkeeping.contractor;

public class Contractor {

    private long contractorId;
    private String name;
    private String nip;

    public Contractor(long contractorId, String name, String nip) {
        this.contractorId = contractorId;
        this.name = name;
        this.nip = nip;
    }

    public Contractor(String line) {
        String[] split = line.split(",");
        this.contractorId = Long.parseLong(split[0]);
        this.nip = split[1];
        this.name = split[2];
    }

    public long getContractorId() {
        return contractorId;
    }

    public String getName() {
        return name;
    }

    public String getNip() {
        return nip;
    }

    public void getBio() {
        System.out.println("Name: " + name);
        System.out.println("Contractor ID: " + contractorId);
        System.out.println("NIP: " + nip);
    }
}
