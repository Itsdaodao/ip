package george.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.List;

import george.exceptions.GeorgeException;

public class DateTimeParser {

    private static final List<DateTimeFormatter> TIME_FORMATTERS = Arrays.asList(
            DateTimeFormatter.ofPattern("yyyy-MM-dd HHmm"),
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")
    );

    private static final List<DateTimeFormatter> DATE_FORMATTERS = Arrays.asList(
            DateTimeFormatter.ofPattern("yyyy-MM-dd"),
            DateTimeFormatter.ofPattern("yyyy/MM/dd")
    );

    /**
     * Parses a datetime string into a LocalDateTime object.
     * Tries multiple common formats until one succeeds.
     *
     * @param dateTimeString the input datetime string
     * @return LocalDateTime object representing the parsed datetime
     * @throws GeorgeException if the string cannot be parsed with any known format
     */
    public static LocalDateTime parseDateTime(String dateTimeString) throws GeorgeException {
        if (dateTimeString == null || dateTimeString.trim().isEmpty()) {
            throw new GeorgeException("DateTime string cannot be null or empty");
        }
        String trimmedInput = dateTimeString.trim();
        for (DateTimeFormatter formatter : TIME_FORMATTERS) {
            try {
                return LocalDateTime.parse(trimmedInput, formatter);
            } catch (DateTimeParseException e) {
                continue;
            }
        }

        for (DateTimeFormatter formatter : DATE_FORMATTERS) {
            try {
                LocalDate date = LocalDate.parse(trimmedInput, formatter);
                return date.atStartOfDay();
            } catch (DateTimeParseException e) {
                continue;
            }
        }

        throw new GeorgeException(
                "Unable to parse datetime string: '" + dateTimeString +
                        "'. Supported formats include (yyyy/MM/dd), " +
                        "(yyyy/MM/dd hh:mm)."
        );
    }

    /**
     * Convenience method that returns the supported formats for reference.
     *
     * @return List of example datetime format patterns
     */
    public List<String> getSupportedFormats() {
        return Arrays.asList(
                "yyyy-MM-dd",
                "yyyy/MM/dd",
                "yyyy-MM-dd HH:mm",
                "yyyy-MM-dd HHmm"
        );
    }

    public List<String> getSupportedExamples() {
        return Arrays.asList(
                "2025-04-10",
                "2025/03/25",
                "2025/12/25 15:45",
                "2019-08-17 0137"
        );
    }
}