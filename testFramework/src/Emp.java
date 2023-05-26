public class Emp{
    private int id ;
    private String nom;
    private double salaire;

    public Emp(){}

    public Emp(int id, String nom, double salaire) {
        this.id = id;
        this.nom = nom;
        this.salaire = salaire;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public double getSalaire() {
        return salaire;
    }
    public void setSalaire(double salaire) {
        this.salaire = salaire;
    }

    @UrlAnnotation(Url =" empAll ")
    public static void FindAll(){
        System.out.println("Hello framework");
    }

    @UrlAnnotation(Url = " update_salaryes ")
    public void prime_salaire(){
        System.out.println("Hi salary");
    }
    
}