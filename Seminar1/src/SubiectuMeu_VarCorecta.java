import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Cititor {
    //schimbare nume clasa in Cititor
    public static final String selectQuery = "Select * from cititori";
    private int id_cititor;
    private String nume;
    private String strada;
    private int numar;

    public Cititor(int id_cititor, String nume, String strada, int numar) {
        this.id_cititor = id_cititor;
        this.nume = nume;
        this.strada = strada;
        this.numar = numar;
    }

    public int getId_cititor() {
        return id_cititor;
    }

    public void setId_cititor(int id_cititor) {
        this.id_cititor = id_cititor;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getStrada() {
        return strada;
    }

    public void setStrada(String strada) {
        this.strada = strada;
    }

    public int getNumar() {
        return numar;
    }

    public void setNumar(int numar) {
        this.numar = numar;
    }

    @Override
    public String toString() {
        return "Cititor{" +
                "id_cititor=" + id_cititor +
                ", nume='" + nume + '\'' +
                ", strada='" + strada + '\'' +
                ", numar=" + numar +
                '}';
    }

    public static void main(String[] args) throws SQLException {
        String url = "jdbc:sqlite:ResurseExamen\\examen.db";

        List<Cititor> listaCititori = new ArrayList<>(); //schimbare nume variabila din lista in listaCititori pentru o sugestivitate mai buna
        List<String> sectoare = new ArrayList<>(); //declarare variabila pe o singura linie
        //utilizarea spatiilor intre declaratii pentru o mai usoara citire a programului
        try(Connection con = DriverManager.getConnection(url);
            Statement s = con.createStatement();
            ResultSet date = s.executeQuery(selectQuery))/*transformare string hardcodat intr-o variabila constanta*/{
            while(date.next()){
                String linie = date.getString("adresa");
                String cuvinte[] =linie/*.replace(" ","")*/.split(",") ;
                sectoare.add(cuvinte[0]);
                String nume = date.getString("nume");
                int id = date.getInt("id_cititor");

                Cititor cititor = new Cititor(id,nume,cuvinte[1],Integer.valueOf(cuvinte[2]));
                listaCititori.add(cititor);
            }
        }

        listaCititori.forEach(System.out::println);
        System.out.printf("%s  %s \n","denumire sector","numar");
        /*System.out.println();*/ //rescrierea liniilor 84 si 85 intr o singura linie prin adaugarea \n

        Map<Object, Long> map = sectoare.stream()
                        .collect(Collectors.
                                groupingBy(x->x,Collectors.counting())
                        );//reformatare cod pentru a putea fi citit mai usor

        for (var x :
                map.keySet()) {
            System.out.print(x + "\t\t\t ");
            System.out.println(map.get(x)+ " ");
        }//folosirea unui foreach este benefica deoarece este mai usor de inteles decat iterarea cu un contor
        //prin toate valorile array-ului
    }
}
