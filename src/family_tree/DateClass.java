package family_tree;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

public class DateClass extends DataAbstractClass{
    /**
     * Возвращает возраст в годах , из даты рождения  вычетает дату смерти.
     * @param birthDateStr дата рождения в формате "дд.мм.гггг"
     * @param deathDateStr дата смерти в формате "дд.мм.гггг"
     * @return
     */
    @Override
    protected int raznitsaVremeni(String birthDateStr, String deathDateStr) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        try {
            Date birthDate = dateFormat.parse(birthDateStr);
            Date deathDate = dateFormat.parse(deathDateStr);
            LocalDate localBirthDate = birthDate.toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDate();
            LocalDate localDeathDate = deathDate.toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDate();
            Period period = Period.between(localBirthDate, localDeathDate);
            return period.getYears();
        } catch (ParseException e) {
            return 0;
        }
    }

    /**
     * Возвращает возраст в годах из сегодняшней даты вычетает дату рождения.
     */
    @Override
    protected int calculateAge(String birthDateStr) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        try {
            Date birthDate = dateFormat.parse(birthDateStr);
            LocalDate localBirthDate = birthDate.toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDate();
            LocalDate today = LocalDate.now();
            Period period = Period.between(localBirthDate, today);
            return period.getYears();
        } catch (ParseException e) {
            return 0;
        }
    }
}
