
package com.ims.webService;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.ims.webService package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetRoleByUser_QNAME = new QName("http://webService.ims.com/", "getRoleByUser");
    private final static QName _GetRoleByUserResponse_QNAME = new QName("http://webService.ims.com/", "getRoleByUserResponse");
    private final static QName _Say_QNAME = new QName("http://webService.ims.com/", "say");
    private final static QName _SayResponse_QNAME = new QName("http://webService.ims.com/", "sayResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.ims.webService
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetRoleByUser }
     * 
     */
    public GetRoleByUser createGetRoleByUser() {
        return new GetRoleByUser();
    }

    /**
     * Create an instance of {@link GetRoleByUserResponse }
     * 
     */
    public GetRoleByUserResponse createGetRoleByUserResponse() {
        return new GetRoleByUserResponse();
    }

    /**
     * Create an instance of {@link Say }
     * 
     */
    public Say createSay() {
        return new Say();
    }

    /**
     * Create an instance of {@link SayResponse }
     * 
     */
    public SayResponse createSayResponse() {
        return new SayResponse();
    }

    /**
     * Create an instance of {@link User }
     * 
     */
    public User createUser() {
        return new User();
    }

    /**
     * Create an instance of {@link Role }
     * 
     */
    public Role createRole() {
        return new Role();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetRoleByUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService.ims.com/", name = "getRoleByUser")
    public JAXBElement<GetRoleByUser> createGetRoleByUser(GetRoleByUser value) {
        return new JAXBElement<GetRoleByUser>(_GetRoleByUser_QNAME, GetRoleByUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetRoleByUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService.ims.com/", name = "getRoleByUserResponse")
    public JAXBElement<GetRoleByUserResponse> createGetRoleByUserResponse(GetRoleByUserResponse value) {
        return new JAXBElement<GetRoleByUserResponse>(_GetRoleByUserResponse_QNAME, GetRoleByUserResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Say }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService.ims.com/", name = "say")
    public JAXBElement<Say> createSay(Say value) {
        return new JAXBElement<Say>(_Say_QNAME, Say.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SayResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService.ims.com/", name = "sayResponse")
    public JAXBElement<SayResponse> createSayResponse(SayResponse value) {
        return new JAXBElement<SayResponse>(_SayResponse_QNAME, SayResponse.class, null, value);
    }

}
