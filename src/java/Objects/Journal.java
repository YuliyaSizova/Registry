/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Objects;

/**
 *
 * @author ASUS
 */
public class Journal {
   private int id_journal;
   private Ticket ticket;
  
   private String diagnosis;
   private String med="";

    /**
     * @return the id_journal
     */
    public int getId_journal() {
        return id_journal;
    }

    /**
     * @param id_journal the id_journal to set
     */
    public void setId_journal(int id_journal) {
        this.id_journal = id_journal;
    }

    /**
     * @return the ticket
     */
    public Ticket getTicket() {
        return ticket;
    }

    /**
     * @param ticket the ticket to set
     */
    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    /**
     * @return the sick_list
     */

    /**
     * @return the diagnosis
     */
    public String getDiagnosis() {
        return diagnosis;
    }

    /**
     * @param diagnosis the diagnosis to set
     */
    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    /**
     * @return the med
     */
    public String getMed() {
        return med;
    }

    /**
     * @param med the med to set
     */
    public void setMed(String med) {
        this.med = med;
    }
}
