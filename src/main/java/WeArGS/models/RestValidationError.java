package WeArGS.models;

public record RestValidationError(
        Integer code,
        String field,
        String message
) {}
