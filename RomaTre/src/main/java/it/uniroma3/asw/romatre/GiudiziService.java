package it.uniroma3.asw.romatre;

public interface GiudiziService {
    public String getGiudizio(String dipartimento);
    
    public String getGiudizio(String dipartimento, String indicatore);
}