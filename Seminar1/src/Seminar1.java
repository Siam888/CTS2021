/*Fie tabela cititori din baza de date sqlite, examen.db. Structura tabelei este:

        id_cititor - integer

        nume - varchar(50)

        adresa - varchar(100)

        În câmpul adresa se află sectorul, strada și numărul despărțite prin virgulă. Pentru sector valorile posibile sunt: "Sector1",...,"Sector6".



        1. Să se citească înregistrările din tabela cititori într-o listă de cititori (List<Cititor>) unde Cititor este o clasă care are câmpurile private: id (int), nume (String), strada (String) și numar (int). Să se afișeze la consolă lista de cititori cu toate câmpurile.

        2. Să se afișeze la consolă un tabel cu două coloane: denumire sector, număr cititori.*/

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class SubiectuMeu {
    private int id_cititor;
    private String nume;
    private String strada;
    private int numar;

    public SubiectuMeu(int id_cititor, String nume, String strada, int numar) {
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
        return "SubiectuMeu{" +
                "id_cititor=" + id_cititor +
                ", nume='" + nume + '\'' +
                ", strada='" + strada + '\'' +
                ", numar=" + numar +
                '}';
    }

    public static void main(String[] args) throws SQLException {
        String url = "jdbc:sqlite:ResurseExamen\\examen.db";

        List<SubiectuMeu> lista = new ArrayList<>();
        List<String> sectoare ;
        sectoare = new ArrayList<>();
        try(Connection con = DriverManager.getConnection(url);
            Statement s = con.createStatement();
            ResultSet date = s.executeQuery("Select * from cititori")){
            while(date.next()){
                String linie = date.getString("adresa");
                String cuvinte[] =linie/*.replace(" ","")*/.split(",") ;
                sectoare.add(cuvinte[0]);
                String nume = date.getString("nume");
                int id = date.getInt("id_cititor");

                SubiectuMeu subiectuMeu = new SubiectuMeu(id,nume,cuvinte[1],Integer.valueOf(cuvinte[2]));
                lista.add(subiectuMeu);
            }
        }

        lista.forEach(System.out::println);
        System.out.printf("%s  %s","denumire sector","numar");
        System.out.println();
        Map<Object, Long> map = sectoare.stream().collect(Collectors.groupingBy(x->x,Collectors.counting()));

        for (var x :
                map.keySet()) {
            System.out.print(x + "\t\t\t ");
            System.out.println(map.get(x)+ " ");
        }
    }
}
