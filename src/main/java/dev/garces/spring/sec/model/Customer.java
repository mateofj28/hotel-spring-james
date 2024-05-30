package dev.garces.spring.sec.model;
import javax.persistence.*;

@Entity
@Table(name = "Customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "document_type_id_customer", nullable = false)
    private DocumentType documentType;

    @Column(name = "identification_customer", length = 20)
    private String identification;

    @Column(name = "dv_customer")
    private int dv;

    @Column(name = "first_name_customer", length = 30)
    private String firstName;

    @Column(name = "second_name_customer", length = 30)
    private String secondName;

    @Column(name = "first_lastname_customer", length = 30)
    private String firstLastName;

    @Column(name = "second_lastname_customer", length = 30)
    private String secondLastName;

    @Column(name = "company_customer", length = 100)
    private String company;

    @Column(name = "address_customer", length = 80)
    private String address;

    @Column(name = "phone_customer", length = 20)
    private String phone;

    @Column(name = "email_customer", length = 100)
    private String email;

    @ManyToOne
    @JoinColumn(name = "country_id_customer")
    private Country country;

    @ManyToOne
    @JoinColumn(name = "department_id_customer")
    private Department department;

    @ManyToOne
    @JoinColumn(name = "city_id_customer")
    private City city;

    @ManyToOne
    @JoinColumn(name = "vat_responsibility_id_customer")
    private CategoryResponsibility vatResponsibility;

    @ManyToOne
    @JoinColumn(name = "fiscal_responsibility_id_customer")
    private FiscalResponsibility fiscalResponsibility;

    @ManyToOne
    @JoinColumn(name = "client_supplier_employee_third_party")
    private PersonType clientSupplierEmployeeThirdParty;

    @ManyToOne
    @JoinColumn(name = "third_party_type_customer")
    private TypeAsignation thirdPartyType;

    @Column(name = "active_customer")
    private boolean active;
}
