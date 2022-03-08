package jdevhl.parser;

public class XMLParser {
    private static final String S_SOAP_ENV_SOAP_S_REGEX = "\\s*<\\/?(?:SOAP-ENV|soap):(?:.|\\s)*?>";

    public static String cleanSoapEnvelopeAndBody(String xml) {
        return xml.replaceAll(S_SOAP_ENV_SOAP_S_REGEX, "");
    }
}
