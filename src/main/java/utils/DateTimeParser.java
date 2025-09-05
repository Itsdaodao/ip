package utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.List;
import exceptions.GeorgeException;

public class DateTimeParser {

    private static final List<DateTimeFormatter> FORMATTERS = Arrays.asList(
            DateTimeFormatter.ofPattern("yyyy-MM-dd"),
            DateTimeFormatter.ofPattern("yyyy/MM/dd"),
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"),
            DateTimeFormatter.ofPattern("yyyy-MM-dd HHmm")
    );

    /**
     * Parses a datetime string into a LocalDateTime object.
     * Tries multiple common formats until one succeeds.
     *
     * @param dateTimeString the input datetime string
     * @return LocalDateTime object representing the parsed datetime
     * @throws IllegalArgumentException if the string cannot be parsed with any known format
     */
    public LocalDateTime parseDateTime(String dateTimeString) throws GeorgeException {
        if (dateTimeString == null || dateTimeString.trim().isEmpty()) {
            throw new GeorgeException("DateTime string cannot be null or empty");
        }
        String trimmedInput = dateTimeString.trim();
        for (DateTimeFormatter formatter : FORMATTERS) {
            try {
                return LocalDateTime.parse(trimmedInput, formatter);
            } catch (DateTimeParseException e) {
                continue;
            }
        }

        throw new IllegalArgumentException(
                "Unable to parse datetime string: '" + dateTimeString +
                        "'. Supported formats include ISO formats, US formats (MM/dd/yyyy), " +
                        "European formats (dd/MM/yyyy), and various other common patterns."
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