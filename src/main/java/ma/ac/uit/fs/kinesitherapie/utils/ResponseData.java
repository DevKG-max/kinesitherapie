package ma.ac.uit.fs.kinesitherapie.utils;

import java.util.UUID;

public record ResponseData(int result, String message, UUID uuidSavedObject) {
}
