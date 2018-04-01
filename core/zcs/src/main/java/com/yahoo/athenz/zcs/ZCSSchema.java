//
// This file generated by rdl 1.5.0
//

package com.yahoo.athenz.zcs;
import com.yahoo.rdl.*;

public class ZCSSchema {

    private final static Schema INSTANCE = build();
    public static Schema instance() {
        return INSTANCE;
    }

    private static Schema build() {
        SchemaBuilder sb = new SchemaBuilder("ZCS");
        sb.version(1);
        sb.namespace("com.yahoo.athenz.zcs");

        sb.stringType("SimpleName")
            .comment("Common name types used by several API definitions A simple identifier, an element of compound name.")
            .pattern("[a-zA-Z0-9_][a-zA-Z0-9_-]*");

        sb.stringType("CompoundName")
            .comment("A compound name. Most names in this API are compound names.")
            .pattern("([a-zA-Z0-9_][a-zA-Z0-9_-]*\\.)*[a-zA-Z0-9_][a-zA-Z0-9_-]*");

        sb.stringType("DomainName")
            .comment("A domain name is the general qualifier prefix, as its uniqueness is managed.")
            .pattern("([a-zA-Z0-9_][a-zA-Z0-9_-]*\\.)*[a-zA-Z0-9_][a-zA-Z0-9_-]*");

        sb.stringType("EntityName")
            .comment("An entity name is a short form of a resource name, including only the domain and entity.")
            .pattern("([a-zA-Z0-9_][a-zA-Z0-9_-]*\\.)*[a-zA-Z0-9_][a-zA-Z0-9_-]*");

        sb.stringType("EntityList")
            .comment("An Entity list is comma separated compound Names")
            .pattern("(([a-zA-Z0-9_][a-zA-Z0-9_-]*\\.)*[a-zA-Z0-9_][a-zA-Z0-9_-]*,)*([a-zA-Z0-9_][a-zA-Z0-9_-]*\\.)*[a-zA-Z0-9_][a-zA-Z0-9_-]*");

        sb.stringType("ServiceName")
            .comment("A service name will generally be a unique subdomain.")
            .pattern("([a-zA-Z0-9_][a-zA-Z0-9_-]*\\.)*[a-zA-Z0-9_][a-zA-Z0-9_-]*");

        sb.stringType("ActionName")
            .comment("An action (operation) name.")
            .pattern("([a-zA-Z0-9_][a-zA-Z0-9_-]*\\.)*[a-zA-Z0-9_][a-zA-Z0-9_-]*");

        sb.stringType("ResourceName")
            .comment("A resource name Note that the EntityName part is optional, that is, a domain name followed by a colon is valid resource name.")
            .pattern("([a-zA-Z0-9_][a-zA-Z0-9_-]*\\.)*[a-zA-Z0-9_][a-zA-Z0-9_-]*(:([a-zA-Z0-9_][a-zA-Z0-9_-]*\\.)*[a-zA-Z0-9_][a-zA-Z0-9_-]*)?");

        sb.stringType("YBase64")
            .comment("The Y-specific URL-safe Base64 variant.")
            .pattern("[a-zA-Z0-9\\._-]+");

        sb.stringType("YEncoded")
            .comment("YEncoded includes ybase64 chars, as well as = and %. This can represent a user cookie and URL-encoded values.")
            .pattern("[a-zA-Z0-9\\._%=-]*");

        sb.stringType("AuthorityName")
            .comment("Used as the prefix in a signed assertion. This uniquely identifies a signing authority.")
            .pattern("([a-zA-Z0-9_][a-zA-Z0-9_-]*\\.)*[a-zA-Z0-9_][a-zA-Z0-9_-]*");

        sb.stringType("SignedToken")
            .comment("A signed assertion if identity. i.e. the user cookie value. This token will only make sense to the authority that generated it, so it is beneficial to have something in the value that is cheaply recognized to quickly reject if it belongs to another authority. In addition to the YEncoded set our token includes ; to separate components and , to separate roles")
            .pattern("[a-zA-Z0-9\\._%=;,-]*");

        sb.stringType("PathElement")
            .comment("A uri-safe path element")
            .pattern("[a-zA-Z0-9-\\._~=+@$,:]*");

        sb.structType("SamlLogin")
            .comment("The representation for SAML login message object")
            .field("code", "Int32", false, "message code")
            .field("message", "String", false, "SAML login message of the server");

        sb.structType("SamlLogout")
            .comment("The representation for SAML logout message object")
            .field("code", "Int32", false, "message code")
            .field("message", "String", false, "SAML logout message of the server");

        sb.stringType("URL")
            .pattern("^(http|https)://([a-zA-Z0-9_][a-zA-Z0-9_-]*\\.)+[a-zA-Z0-9_][a-zA-Z0-9_-]*(/[a-zA-Z0-9_\\./?%&=]*)?$");

        sb.structType("Status")
            .comment("The representation for a status object")
            .field("code", "Int32", false, "status message code")
            .field("message", "String", false, "status message of the server");


        sb.resource("SamlLogin", "GET", "/saml/login")
            .queryParam("url", "url", "URL", null, "")
            .output("Location", "location", "String", "return location for subsequent patch requests")
            .auth("", "", true)
            .expected("OK")
            .exception("BAD_REQUEST", "ResourceError", "")

            .exception("FORBIDDEN", "ResourceError", "")

            .exception("TOO_MANY_REQUESTS", "ResourceError", "")

            .exception("UNAUTHORIZED", "ResourceError", "")
;

        sb.resource("SamlLogout", "GET", "/saml/logout")
            .queryParam("url", "url", "URL", null, "")
            .output("Location", "location", "String", "return location for subsequent patch requests")
            .expected("OK")
            .exception("BAD_REQUEST", "ResourceError", "")

            .exception("FORBIDDEN", "ResourceError", "")

            .exception("TOO_MANY_REQUESTS", "ResourceError", "")

            .exception("UNAUTHORIZED", "ResourceError", "")
;

        sb.resource("Status", "GET", "/status")
            .comment("Retrieve the server status")
            .expected("OK")
            .exception("BAD_REQUEST", "ResourceError", "")

            .exception("NOT_FOUND", "ResourceError", "")

            .exception("UNAUTHORIZED", "ResourceError", "")
;


        return sb.build();
    }

}