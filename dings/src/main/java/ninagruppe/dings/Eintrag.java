package ninagruppe.dings;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Eintrag
{
    @Id
    @GeneratedValue
    private Long id;
    private String text;
    private LocalDateTime saveTime;
    private int tage;
    private int minuten;

    public Eintrag()
    {
        saveTime = LocalDateTime.now();
    }

    public Eintrag(String text)
    {
        this.setText(text);
        saveTime = LocalDateTime.now();
    }

    private int calculateMinutesUntilNow()
    {
        return (int) ChronoUnit.MINUTES.between(saveTime, LocalDateTime.now());
    }

    public int getMinuten()
    {
        minuten = calculateMinutesUntilNow();
        return minuten;
    }

    private int calculateDaysUntilNow()
    {
        return (int) ChronoUnit.DAYS.between(saveTime, LocalDateTime.now());
    }

    public int getTage()
    {
        tage = calculateDaysUntilNow();
        return tage;
    }

    public String getText()
    {
        return text;
    }

    public void setText(String text)
    {
        this.text = text;
    }

    public void setMinuten(int minuten)
    {
        this.minuten = minuten;
    }

    public void setTage(int tage)
    {
        this.tage = tage;
    }

}
