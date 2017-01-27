
package introsde.storage.soap.ws;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the introsde.storage.soap.ws package. 
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

    private final static QName _ReadPersonHistoryResponse_QNAME = new QName("http://ws.soap.health.introsde/", "readPersonHistoryResponse");
    private final static QName _UpdatePersonResponse_QNAME = new QName("http://ws.soap.health.introsde/", "updatePersonResponse");
    private final static QName _CreateGoalResponse_QNAME = new QName("http://ws.soap.health.introsde/", "createGoalResponse");
    private final static QName _ReadPersonHistory_QNAME = new QName("http://ws.soap.health.introsde/", "readPersonHistory");
    private final static QName _Measure_QNAME = new QName("http://ws.soap.health.introsde/", "measure");
    private final static QName _ReadPersonResponse_QNAME = new QName("http://ws.soap.health.introsde/", "readPersonResponse");
    private final static QName _Person_QNAME = new QName("http://ws.soap.health.introsde/", "person");
    private final static QName _ReadPerson_QNAME = new QName("http://ws.soap.health.introsde/", "readPerson");
    private final static QName _CreateGoal_QNAME = new QName("http://ws.soap.health.introsde/", "createGoal");
    private final static QName _DeleteGoal_QNAME = new QName("http://ws.soap.health.introsde/", "deleteGoal");
    private final static QName _ReadPersonMeasure_QNAME = new QName("http://ws.soap.health.introsde/", "readPersonMeasure");
    private final static QName _ReadPersonMeasureResponse_QNAME = new QName("http://ws.soap.health.introsde/", "readPersonMeasureResponse");
    private final static QName _UpdatePerson_QNAME = new QName("http://ws.soap.health.introsde/", "updatePerson");
    private final static QName _DeletePerson_QNAME = new QName("http://ws.soap.health.introsde/", "deletePerson");
    private final static QName _ReadPersonGoalByNameAndStatus_QNAME = new QName("http://ws.soap.health.introsde/", "readPersonGoalByNameAndStatus");
    private final static QName _CreatePersonResponse_QNAME = new QName("http://ws.soap.health.introsde/", "createPersonResponse");
    private final static QName _ReadPersonGoalByNameAndStatusResponse_QNAME = new QName("http://ws.soap.health.introsde/", "readPersonGoalByNameAndStatusResponse");
    private final static QName _ReadPersonGoalByStatusResponse_QNAME = new QName("http://ws.soap.health.introsde/", "readPersonGoalByStatusResponse");
    private final static QName _Goal_QNAME = new QName("http://ws.soap.health.introsde/", "goal");
    private final static QName _UpdateGoalResponse_QNAME = new QName("http://ws.soap.health.introsde/", "updateGoalResponse");
    private final static QName _SavePersonMeasure_QNAME = new QName("http://ws.soap.health.introsde/", "savePersonMeasure");
    private final static QName _SavePersonMeasureResponse_QNAME = new QName("http://ws.soap.health.introsde/", "savePersonMeasureResponse");
    private final static QName _CreatePerson_QNAME = new QName("http://ws.soap.health.introsde/", "createPerson");
    private final static QName _ReadPersonGoalByNameResponse_QNAME = new QName("http://ws.soap.health.introsde/", "readPersonGoalByNameResponse");
    private final static QName _UpdateGoal_QNAME = new QName("http://ws.soap.health.introsde/", "updateGoal");
    private final static QName _ReadMeasureTypes_QNAME = new QName("http://ws.soap.health.introsde/", "readMeasureTypes");
    private final static QName _UpdatePersonMeasure_QNAME = new QName("http://ws.soap.health.introsde/", "updatePersonMeasure");
    private final static QName _ReadPersonGoalListResponse_QNAME = new QName("http://ws.soap.health.introsde/", "readPersonGoalListResponse");
    private final static QName _ReadPersonListResponse_QNAME = new QName("http://ws.soap.health.introsde/", "readPersonListResponse");
    private final static QName _DeletePersonResponse_QNAME = new QName("http://ws.soap.health.introsde/", "deletePersonResponse");
    private final static QName _UpdatePersonMeasureResponse_QNAME = new QName("http://ws.soap.health.introsde/", "updatePersonMeasureResponse");
    private final static QName _ReadPersonList_QNAME = new QName("http://ws.soap.health.introsde/", "readPersonList");
    private final static QName _ReadPersonGoalByStatus_QNAME = new QName("http://ws.soap.health.introsde/", "readPersonGoalByStatus");
    private final static QName _InitializeDatabase_QNAME = new QName("http://ws.soap.health.introsde/", "initializeDatabase");
    private final static QName _ReadGoalResponse_QNAME = new QName("http://ws.soap.health.introsde/", "readGoalResponse");
    private final static QName _ReadPersonGoalById_QNAME = new QName("http://ws.soap.health.introsde/", "readPersonGoalById");
    private final static QName _DeleteGoalResponse_QNAME = new QName("http://ws.soap.health.introsde/", "deleteGoalResponse");
    private final static QName _ReadMeasureTypesResponse_QNAME = new QName("http://ws.soap.health.introsde/", "readMeasureTypesResponse");
    private final static QName _ReadPersonGoalByIdResponse_QNAME = new QName("http://ws.soap.health.introsde/", "readPersonGoalByIdResponse");
    private final static QName _ReadGoalListResponse_QNAME = new QName("http://ws.soap.health.introsde/", "readGoalListResponse");
    private final static QName _ReadPersonGoalByName_QNAME = new QName("http://ws.soap.health.introsde/", "readPersonGoalByName");
    private final static QName _InitializeDatabaseResponse_QNAME = new QName("http://ws.soap.health.introsde/", "initializeDatabaseResponse");
    private final static QName _ReadGoal_QNAME = new QName("http://ws.soap.health.introsde/", "readGoal");
    private final static QName _ReadPersonGoalList_QNAME = new QName("http://ws.soap.health.introsde/", "readPersonGoalList");
    private final static QName _ReadGoalList_QNAME = new QName("http://ws.soap.health.introsde/", "readGoalList");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: introsde.storage.soap.ws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Person }
     * 
     */
    public Person createPerson() {
        return new Person();
    }

    /**
     * Create an instance of {@link DeleteGoalResponse }
     * 
     */
    public DeleteGoalResponse createDeleteGoalResponse() {
        return new DeleteGoalResponse();
    }

    /**
     * Create an instance of {@link ReadMeasureTypesResponse }
     * 
     */
    public ReadMeasureTypesResponse createReadMeasureTypesResponse() {
        return new ReadMeasureTypesResponse();
    }

    /**
     * Create an instance of {@link ReadPersonGoalByIdResponse }
     * 
     */
    public ReadPersonGoalByIdResponse createReadPersonGoalByIdResponse() {
        return new ReadPersonGoalByIdResponse();
    }

    /**
     * Create an instance of {@link ReadGoalListResponse }
     * 
     */
    public ReadGoalListResponse createReadGoalListResponse() {
        return new ReadGoalListResponse();
    }

    /**
     * Create an instance of {@link ReadPersonGoalByName }
     * 
     */
    public ReadPersonGoalByName createReadPersonGoalByName() {
        return new ReadPersonGoalByName();
    }

    /**
     * Create an instance of {@link InitializeDatabaseResponse }
     * 
     */
    public InitializeDatabaseResponse createInitializeDatabaseResponse() {
        return new InitializeDatabaseResponse();
    }

    /**
     * Create an instance of {@link ReadGoal }
     * 
     */
    public ReadGoal createReadGoal() {
        return new ReadGoal();
    }

    /**
     * Create an instance of {@link ReadPersonGoalList }
     * 
     */
    public ReadPersonGoalList createReadPersonGoalList() {
        return new ReadPersonGoalList();
    }

    /**
     * Create an instance of {@link ReadGoalList }
     * 
     */
    public ReadGoalList createReadGoalList() {
        return new ReadGoalList();
    }

    /**
     * Create an instance of {@link ReadPersonGoalListResponse }
     * 
     */
    public ReadPersonGoalListResponse createReadPersonGoalListResponse() {
        return new ReadPersonGoalListResponse();
    }

    /**
     * Create an instance of {@link ReadPersonListResponse }
     * 
     */
    public ReadPersonListResponse createReadPersonListResponse() {
        return new ReadPersonListResponse();
    }

    /**
     * Create an instance of {@link DeletePersonResponse }
     * 
     */
    public DeletePersonResponse createDeletePersonResponse() {
        return new DeletePersonResponse();
    }

    /**
     * Create an instance of {@link UpdatePersonMeasureResponse }
     * 
     */
    public UpdatePersonMeasureResponse createUpdatePersonMeasureResponse() {
        return new UpdatePersonMeasureResponse();
    }

    /**
     * Create an instance of {@link ReadPersonList }
     * 
     */
    public ReadPersonList createReadPersonList() {
        return new ReadPersonList();
    }

    /**
     * Create an instance of {@link ReadPersonGoalByStatus }
     * 
     */
    public ReadPersonGoalByStatus createReadPersonGoalByStatus() {
        return new ReadPersonGoalByStatus();
    }

    /**
     * Create an instance of {@link InitializeDatabase }
     * 
     */
    public InitializeDatabase createInitializeDatabase() {
        return new InitializeDatabase();
    }

    /**
     * Create an instance of {@link ReadGoalResponse }
     * 
     */
    public ReadGoalResponse createReadGoalResponse() {
        return new ReadGoalResponse();
    }

    /**
     * Create an instance of {@link ReadPersonGoalById }
     * 
     */
    public ReadPersonGoalById createReadPersonGoalById() {
        return new ReadPersonGoalById();
    }

    /**
     * Create an instance of {@link DeletePerson }
     * 
     */
    public DeletePerson createDeletePerson() {
        return new DeletePerson();
    }

    /**
     * Create an instance of {@link ReadPersonGoalByNameAndStatus }
     * 
     */
    public ReadPersonGoalByNameAndStatus createReadPersonGoalByNameAndStatus() {
        return new ReadPersonGoalByNameAndStatus();
    }

    /**
     * Create an instance of {@link CreatePersonResponse }
     * 
     */
    public CreatePersonResponse createCreatePersonResponse() {
        return new CreatePersonResponse();
    }

    /**
     * Create an instance of {@link ReadPersonGoalByNameAndStatusResponse }
     * 
     */
    public ReadPersonGoalByNameAndStatusResponse createReadPersonGoalByNameAndStatusResponse() {
        return new ReadPersonGoalByNameAndStatusResponse();
    }

    /**
     * Create an instance of {@link ReadPersonGoalByStatusResponse }
     * 
     */
    public ReadPersonGoalByStatusResponse createReadPersonGoalByStatusResponse() {
        return new ReadPersonGoalByStatusResponse();
    }

    /**
     * Create an instance of {@link Goal }
     * 
     */
    public Goal createGoal() {
        return new Goal();
    }

    /**
     * Create an instance of {@link UpdateGoalResponse }
     * 
     */
    public UpdateGoalResponse createUpdateGoalResponse() {
        return new UpdateGoalResponse();
    }

    /**
     * Create an instance of {@link SavePersonMeasure }
     * 
     */
    public SavePersonMeasure createSavePersonMeasure() {
        return new SavePersonMeasure();
    }

    /**
     * Create an instance of {@link SavePersonMeasureResponse }
     * 
     */
    public SavePersonMeasureResponse createSavePersonMeasureResponse() {
        return new SavePersonMeasureResponse();
    }

    /**
     * Create an instance of {@link CreatePerson }
     * 
     */
    public CreatePerson createCreatePerson() {
        return new CreatePerson();
    }

    /**
     * Create an instance of {@link ReadPersonGoalByNameResponse }
     * 
     */
    public ReadPersonGoalByNameResponse createReadPersonGoalByNameResponse() {
        return new ReadPersonGoalByNameResponse();
    }

    /**
     * Create an instance of {@link UpdateGoal }
     * 
     */
    public UpdateGoal createUpdateGoal() {
        return new UpdateGoal();
    }

    /**
     * Create an instance of {@link ReadMeasureTypes }
     * 
     */
    public ReadMeasureTypes createReadMeasureTypes() {
        return new ReadMeasureTypes();
    }

    /**
     * Create an instance of {@link UpdatePersonMeasure }
     * 
     */
    public UpdatePersonMeasure createUpdatePersonMeasure() {
        return new UpdatePersonMeasure();
    }

    /**
     * Create an instance of {@link ReadPersonHistoryResponse }
     * 
     */
    public ReadPersonHistoryResponse createReadPersonHistoryResponse() {
        return new ReadPersonHistoryResponse();
    }

    /**
     * Create an instance of {@link UpdatePersonResponse }
     * 
     */
    public UpdatePersonResponse createUpdatePersonResponse() {
        return new UpdatePersonResponse();
    }

    /**
     * Create an instance of {@link CreateGoalResponse }
     * 
     */
    public CreateGoalResponse createCreateGoalResponse() {
        return new CreateGoalResponse();
    }

    /**
     * Create an instance of {@link ReadPersonHistory }
     * 
     */
    public ReadPersonHistory createReadPersonHistory() {
        return new ReadPersonHistory();
    }

    /**
     * Create an instance of {@link ReadPersonResponse }
     * 
     */
    public ReadPersonResponse createReadPersonResponse() {
        return new ReadPersonResponse();
    }

    /**
     * Create an instance of {@link ReadPerson }
     * 
     */
    public ReadPerson createReadPerson() {
        return new ReadPerson();
    }

    /**
     * Create an instance of {@link CreateGoal }
     * 
     */
    public CreateGoal createCreateGoal() {
        return new CreateGoal();
    }

    /**
     * Create an instance of {@link DeleteGoal }
     * 
     */
    public DeleteGoal createDeleteGoal() {
        return new DeleteGoal();
    }

    /**
     * Create an instance of {@link ReadPersonMeasure }
     * 
     */
    public ReadPersonMeasure createReadPersonMeasure() {
        return new ReadPersonMeasure();
    }

    /**
     * Create an instance of {@link ReadPersonMeasureResponse }
     * 
     */
    public ReadPersonMeasureResponse createReadPersonMeasureResponse() {
        return new ReadPersonMeasureResponse();
    }

    /**
     * Create an instance of {@link UpdatePerson }
     * 
     */
    public UpdatePerson createUpdatePerson() {
        return new UpdatePerson();
    }

    /**
     * Create an instance of {@link Measurement }
     * 
     */
    public Measurement createMeasurement() {
        return new Measurement();
    }

    /**
     * Create an instance of {@link Measure }
     * 
     */
    public Measure createMeasure() {
        return new Measure();
    }

    /**
     * Create an instance of {@link MeasurementHistory }
     * 
     */
    public MeasurementHistory createMeasurementHistory() {
        return new MeasurementHistory();
    }

    /**
     * Create an instance of {@link Person.HealthProfile }
     * 
     */
    public Person.HealthProfile createPersonHealthProfile() {
        return new Person.HealthProfile();
    }

    /**
     * Create an instance of {@link Person.Goals }
     * 
     */
    public Person.Goals createPersonGoals() {
        return new Person.Goals();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReadPersonHistoryResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.soap.health.introsde/", name = "readPersonHistoryResponse")
    public JAXBElement<ReadPersonHistoryResponse> createReadPersonHistoryResponse(ReadPersonHistoryResponse value) {
        return new JAXBElement<ReadPersonHistoryResponse>(_ReadPersonHistoryResponse_QNAME, ReadPersonHistoryResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdatePersonResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.soap.health.introsde/", name = "updatePersonResponse")
    public JAXBElement<UpdatePersonResponse> createUpdatePersonResponse(UpdatePersonResponse value) {
        return new JAXBElement<UpdatePersonResponse>(_UpdatePersonResponse_QNAME, UpdatePersonResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateGoalResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.soap.health.introsde/", name = "createGoalResponse")
    public JAXBElement<CreateGoalResponse> createCreateGoalResponse(CreateGoalResponse value) {
        return new JAXBElement<CreateGoalResponse>(_CreateGoalResponse_QNAME, CreateGoalResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReadPersonHistory }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.soap.health.introsde/", name = "readPersonHistory")
    public JAXBElement<ReadPersonHistory> createReadPersonHistory(ReadPersonHistory value) {
        return new JAXBElement<ReadPersonHistory>(_ReadPersonHistory_QNAME, ReadPersonHistory.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.soap.health.introsde/", name = "measure")
    public JAXBElement<Object> createMeasure(Object value) {
        return new JAXBElement<Object>(_Measure_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReadPersonResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.soap.health.introsde/", name = "readPersonResponse")
    public JAXBElement<ReadPersonResponse> createReadPersonResponse(ReadPersonResponse value) {
        return new JAXBElement<ReadPersonResponse>(_ReadPersonResponse_QNAME, ReadPersonResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Person }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.soap.health.introsde/", name = "person")
    public JAXBElement<Person> createPerson(Person value) {
        return new JAXBElement<Person>(_Person_QNAME, Person.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReadPerson }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.soap.health.introsde/", name = "readPerson")
    public JAXBElement<ReadPerson> createReadPerson(ReadPerson value) {
        return new JAXBElement<ReadPerson>(_ReadPerson_QNAME, ReadPerson.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateGoal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.soap.health.introsde/", name = "createGoal")
    public JAXBElement<CreateGoal> createCreateGoal(CreateGoal value) {
        return new JAXBElement<CreateGoal>(_CreateGoal_QNAME, CreateGoal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteGoal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.soap.health.introsde/", name = "deleteGoal")
    public JAXBElement<DeleteGoal> createDeleteGoal(DeleteGoal value) {
        return new JAXBElement<DeleteGoal>(_DeleteGoal_QNAME, DeleteGoal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReadPersonMeasure }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.soap.health.introsde/", name = "readPersonMeasure")
    public JAXBElement<ReadPersonMeasure> createReadPersonMeasure(ReadPersonMeasure value) {
        return new JAXBElement<ReadPersonMeasure>(_ReadPersonMeasure_QNAME, ReadPersonMeasure.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReadPersonMeasureResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.soap.health.introsde/", name = "readPersonMeasureResponse")
    public JAXBElement<ReadPersonMeasureResponse> createReadPersonMeasureResponse(ReadPersonMeasureResponse value) {
        return new JAXBElement<ReadPersonMeasureResponse>(_ReadPersonMeasureResponse_QNAME, ReadPersonMeasureResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdatePerson }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.soap.health.introsde/", name = "updatePerson")
    public JAXBElement<UpdatePerson> createUpdatePerson(UpdatePerson value) {
        return new JAXBElement<UpdatePerson>(_UpdatePerson_QNAME, UpdatePerson.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeletePerson }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.soap.health.introsde/", name = "deletePerson")
    public JAXBElement<DeletePerson> createDeletePerson(DeletePerson value) {
        return new JAXBElement<DeletePerson>(_DeletePerson_QNAME, DeletePerson.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReadPersonGoalByNameAndStatus }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.soap.health.introsde/", name = "readPersonGoalByNameAndStatus")
    public JAXBElement<ReadPersonGoalByNameAndStatus> createReadPersonGoalByNameAndStatus(ReadPersonGoalByNameAndStatus value) {
        return new JAXBElement<ReadPersonGoalByNameAndStatus>(_ReadPersonGoalByNameAndStatus_QNAME, ReadPersonGoalByNameAndStatus.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreatePersonResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.soap.health.introsde/", name = "createPersonResponse")
    public JAXBElement<CreatePersonResponse> createCreatePersonResponse(CreatePersonResponse value) {
        return new JAXBElement<CreatePersonResponse>(_CreatePersonResponse_QNAME, CreatePersonResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReadPersonGoalByNameAndStatusResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.soap.health.introsde/", name = "readPersonGoalByNameAndStatusResponse")
    public JAXBElement<ReadPersonGoalByNameAndStatusResponse> createReadPersonGoalByNameAndStatusResponse(ReadPersonGoalByNameAndStatusResponse value) {
        return new JAXBElement<ReadPersonGoalByNameAndStatusResponse>(_ReadPersonGoalByNameAndStatusResponse_QNAME, ReadPersonGoalByNameAndStatusResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReadPersonGoalByStatusResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.soap.health.introsde/", name = "readPersonGoalByStatusResponse")
    public JAXBElement<ReadPersonGoalByStatusResponse> createReadPersonGoalByStatusResponse(ReadPersonGoalByStatusResponse value) {
        return new JAXBElement<ReadPersonGoalByStatusResponse>(_ReadPersonGoalByStatusResponse_QNAME, ReadPersonGoalByStatusResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Goal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.soap.health.introsde/", name = "goal")
    public JAXBElement<Goal> createGoal(Goal value) {
        return new JAXBElement<Goal>(_Goal_QNAME, Goal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateGoalResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.soap.health.introsde/", name = "updateGoalResponse")
    public JAXBElement<UpdateGoalResponse> createUpdateGoalResponse(UpdateGoalResponse value) {
        return new JAXBElement<UpdateGoalResponse>(_UpdateGoalResponse_QNAME, UpdateGoalResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SavePersonMeasure }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.soap.health.introsde/", name = "savePersonMeasure")
    public JAXBElement<SavePersonMeasure> createSavePersonMeasure(SavePersonMeasure value) {
        return new JAXBElement<SavePersonMeasure>(_SavePersonMeasure_QNAME, SavePersonMeasure.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SavePersonMeasureResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.soap.health.introsde/", name = "savePersonMeasureResponse")
    public JAXBElement<SavePersonMeasureResponse> createSavePersonMeasureResponse(SavePersonMeasureResponse value) {
        return new JAXBElement<SavePersonMeasureResponse>(_SavePersonMeasureResponse_QNAME, SavePersonMeasureResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreatePerson }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.soap.health.introsde/", name = "createPerson")
    public JAXBElement<CreatePerson> createCreatePerson(CreatePerson value) {
        return new JAXBElement<CreatePerson>(_CreatePerson_QNAME, CreatePerson.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReadPersonGoalByNameResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.soap.health.introsde/", name = "readPersonGoalByNameResponse")
    public JAXBElement<ReadPersonGoalByNameResponse> createReadPersonGoalByNameResponse(ReadPersonGoalByNameResponse value) {
        return new JAXBElement<ReadPersonGoalByNameResponse>(_ReadPersonGoalByNameResponse_QNAME, ReadPersonGoalByNameResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateGoal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.soap.health.introsde/", name = "updateGoal")
    public JAXBElement<UpdateGoal> createUpdateGoal(UpdateGoal value) {
        return new JAXBElement<UpdateGoal>(_UpdateGoal_QNAME, UpdateGoal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReadMeasureTypes }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.soap.health.introsde/", name = "readMeasureTypes")
    public JAXBElement<ReadMeasureTypes> createReadMeasureTypes(ReadMeasureTypes value) {
        return new JAXBElement<ReadMeasureTypes>(_ReadMeasureTypes_QNAME, ReadMeasureTypes.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdatePersonMeasure }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.soap.health.introsde/", name = "updatePersonMeasure")
    public JAXBElement<UpdatePersonMeasure> createUpdatePersonMeasure(UpdatePersonMeasure value) {
        return new JAXBElement<UpdatePersonMeasure>(_UpdatePersonMeasure_QNAME, UpdatePersonMeasure.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReadPersonGoalListResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.soap.health.introsde/", name = "readPersonGoalListResponse")
    public JAXBElement<ReadPersonGoalListResponse> createReadPersonGoalListResponse(ReadPersonGoalListResponse value) {
        return new JAXBElement<ReadPersonGoalListResponse>(_ReadPersonGoalListResponse_QNAME, ReadPersonGoalListResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReadPersonListResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.soap.health.introsde/", name = "readPersonListResponse")
    public JAXBElement<ReadPersonListResponse> createReadPersonListResponse(ReadPersonListResponse value) {
        return new JAXBElement<ReadPersonListResponse>(_ReadPersonListResponse_QNAME, ReadPersonListResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeletePersonResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.soap.health.introsde/", name = "deletePersonResponse")
    public JAXBElement<DeletePersonResponse> createDeletePersonResponse(DeletePersonResponse value) {
        return new JAXBElement<DeletePersonResponse>(_DeletePersonResponse_QNAME, DeletePersonResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdatePersonMeasureResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.soap.health.introsde/", name = "updatePersonMeasureResponse")
    public JAXBElement<UpdatePersonMeasureResponse> createUpdatePersonMeasureResponse(UpdatePersonMeasureResponse value) {
        return new JAXBElement<UpdatePersonMeasureResponse>(_UpdatePersonMeasureResponse_QNAME, UpdatePersonMeasureResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReadPersonList }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.soap.health.introsde/", name = "readPersonList")
    public JAXBElement<ReadPersonList> createReadPersonList(ReadPersonList value) {
        return new JAXBElement<ReadPersonList>(_ReadPersonList_QNAME, ReadPersonList.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReadPersonGoalByStatus }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.soap.health.introsde/", name = "readPersonGoalByStatus")
    public JAXBElement<ReadPersonGoalByStatus> createReadPersonGoalByStatus(ReadPersonGoalByStatus value) {
        return new JAXBElement<ReadPersonGoalByStatus>(_ReadPersonGoalByStatus_QNAME, ReadPersonGoalByStatus.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InitializeDatabase }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.soap.health.introsde/", name = "initializeDatabase")
    public JAXBElement<InitializeDatabase> createInitializeDatabase(InitializeDatabase value) {
        return new JAXBElement<InitializeDatabase>(_InitializeDatabase_QNAME, InitializeDatabase.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReadGoalResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.soap.health.introsde/", name = "readGoalResponse")
    public JAXBElement<ReadGoalResponse> createReadGoalResponse(ReadGoalResponse value) {
        return new JAXBElement<ReadGoalResponse>(_ReadGoalResponse_QNAME, ReadGoalResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReadPersonGoalById }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.soap.health.introsde/", name = "readPersonGoalById")
    public JAXBElement<ReadPersonGoalById> createReadPersonGoalById(ReadPersonGoalById value) {
        return new JAXBElement<ReadPersonGoalById>(_ReadPersonGoalById_QNAME, ReadPersonGoalById.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteGoalResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.soap.health.introsde/", name = "deleteGoalResponse")
    public JAXBElement<DeleteGoalResponse> createDeleteGoalResponse(DeleteGoalResponse value) {
        return new JAXBElement<DeleteGoalResponse>(_DeleteGoalResponse_QNAME, DeleteGoalResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReadMeasureTypesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.soap.health.introsde/", name = "readMeasureTypesResponse")
    public JAXBElement<ReadMeasureTypesResponse> createReadMeasureTypesResponse(ReadMeasureTypesResponse value) {
        return new JAXBElement<ReadMeasureTypesResponse>(_ReadMeasureTypesResponse_QNAME, ReadMeasureTypesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReadPersonGoalByIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.soap.health.introsde/", name = "readPersonGoalByIdResponse")
    public JAXBElement<ReadPersonGoalByIdResponse> createReadPersonGoalByIdResponse(ReadPersonGoalByIdResponse value) {
        return new JAXBElement<ReadPersonGoalByIdResponse>(_ReadPersonGoalByIdResponse_QNAME, ReadPersonGoalByIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReadGoalListResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.soap.health.introsde/", name = "readGoalListResponse")
    public JAXBElement<ReadGoalListResponse> createReadGoalListResponse(ReadGoalListResponse value) {
        return new JAXBElement<ReadGoalListResponse>(_ReadGoalListResponse_QNAME, ReadGoalListResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReadPersonGoalByName }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.soap.health.introsde/", name = "readPersonGoalByName")
    public JAXBElement<ReadPersonGoalByName> createReadPersonGoalByName(ReadPersonGoalByName value) {
        return new JAXBElement<ReadPersonGoalByName>(_ReadPersonGoalByName_QNAME, ReadPersonGoalByName.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InitializeDatabaseResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.soap.health.introsde/", name = "initializeDatabaseResponse")
    public JAXBElement<InitializeDatabaseResponse> createInitializeDatabaseResponse(InitializeDatabaseResponse value) {
        return new JAXBElement<InitializeDatabaseResponse>(_InitializeDatabaseResponse_QNAME, InitializeDatabaseResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReadGoal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.soap.health.introsde/", name = "readGoal")
    public JAXBElement<ReadGoal> createReadGoal(ReadGoal value) {
        return new JAXBElement<ReadGoal>(_ReadGoal_QNAME, ReadGoal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReadPersonGoalList }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.soap.health.introsde/", name = "readPersonGoalList")
    public JAXBElement<ReadPersonGoalList> createReadPersonGoalList(ReadPersonGoalList value) {
        return new JAXBElement<ReadPersonGoalList>(_ReadPersonGoalList_QNAME, ReadPersonGoalList.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReadGoalList }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.soap.health.introsde/", name = "readGoalList")
    public JAXBElement<ReadGoalList> createReadGoalList(ReadGoalList value) {
        return new JAXBElement<ReadGoalList>(_ReadGoalList_QNAME, ReadGoalList.class, null, value);
    }

}
