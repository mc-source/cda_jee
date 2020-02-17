package cda.afip.servlets;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class Tests {
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy - HH:mm");
	LocalDateTime date = LocalDateTime.now(ZoneId.of("Europe/Paris"));
	String parsedDate = date.format(formatter);

}
