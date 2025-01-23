package ir.adlas.adlasapp.shared.constant;

public class ProjectConstants {

    private ProjectConstants() {}

    // ======================== Application ======================== //
    public static final String APP_VERSION = "v0.0.1";

    // ======================== API Definition ======================== //
    public static final String API_DOCUMENT_INFO_TITLE = "Adlas App Document Information";
    public static final String API_DOCUMENT_INFO_DESCRIPTION = "AdlasApp microservice REST API documentation";
    public static final String API_DOCUMENT_INFO_VERSION = APP_VERSION;
    public static final String API_DOCUMENT_INFO_CONTACT_NAME = "Iman Salehi";
    public static final String API_DOCUMENT_INFO_CONTACT_URL = "https://www.linkedin.com/in/jimsa/";
    public static final String API_DOCUMENT_INFO_CONTACT_EMAIL = "cse.isalehi@gmail.com";
    public static final String API_DOCUMENT_INFO_LICENSE_NAME = "MIT License";
    public static final String API_DOCUMENT_INFO_LICENSE_URL = "https://opensource.org/license/mit";
    public static final String API_DOCUMENT_EXTERNAL_DOCS_DESCRIPTION = "Source code repository";
    public static final String API_DOCUMENT_EXTERNAL_DOCS_URL = "https://github.com/j-imsa/AdlasApp.git";
    public static final String API_DOCUMENT_SERVERS_1_DESCRIPTION = "Dev, local";
    public static final String API_DOCUMENT_SERVERS_1_URL = "http://localhost:8088/";
    public static final String API_DOCUMENT_SERVERS_2_DESCRIPTION = "Dev, Server";
    public static final String API_DOCUMENT_SERVERS_2_URL = "http://152.11.42.185:8090/";

    // ======================== PublicId ======================== //
    public static final String VALIDATION_PUBLIC_ID_DEFAULT_MESSAGE = "Invalid public_id";
    public static final String PUBLIC_ID_PATTERN = "^[A-Za-z0-9-_]+$";
    public static final String PUBLIC_ID_TYPE = "string";
    public static final String PUBLIC_ID_CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_";
    public static final String PUBLIC_ID_DESCRIPTION = "The public_id of the resource";
    public static final String PUBLIC_ID_EXAMPLE_1 = "a7vqO-mCBzlJpgGjSU-HYsTpLblN4El-UEmr8M9LMIm01dqmNIqENiE0RiLIfu9e";
    public static final String PUBLIC_ID_EXAMPLE_2 = "a7vqO-mCBzlJpgGjSU-HYsTpLblN4El-UEmr8M9LMIm01dqmNIqENiE0RiLIfu9y";
    public static final int PUBLIC_ID_MIN_LENGTH = 32;
    public static final int PUBLIC_ID_MAX_LENGTH = 512;
    public static final int PUBLIC_ID_DEFAULT_LENGTH = 64;
    public static final String DOCUMENT_PUBLIC_ID_DESCRIPTION = "The public_id of the resource";
    public static final String DOCUMENT_PUBLIC_ID_EXAMPLE = "a7vqO-mCBzlJpgGjSU-HYsTpLblN4El-UEmr8M9LMIm01dqmNIqENiE0RiLIfu9e";
    public static final String DOCUMENT_PUBLIC_ID_EXAMPLE_1_NAME = "Valid example";
    public static final String DOCUMENT_PUBLIC_ID_EXAMPLE_1_VALUE = "a7vqO-mCBzlJpgGjSU-HYsTpLblN4El-UEmr8M9LMIm01dqmNIqENiE0RiLIfu9e";
    public static final String DOCUMENT_PUBLIC_ID_EXAMPLE_1_SUMMERY = "Example public ID 1, Valid";
    public static final String DOCUMENT_PUBLIC_ID_EXAMPLE_2_NAME = "Invalid example";
    public static final String DOCUMENT_PUBLIC_ID_EXAMPLE_2_VALUE = "xyz789xyz789xyz789x@%&*";
    public static final String DOCUMENT_PUBLIC_ID_EXAMPLE_2_SUMMERY = "Example public ID 2, Invalid";


}
