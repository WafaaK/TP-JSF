package domaines;

import entities.Employe;
import entities.Service;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.RowEditEvent;
import org.primefaces.model.UploadedFile;
import org.primefaces.model.chart.ChartModel;
import service.EmployeService;
import service.ServiceService;

@ManagedBean
@ViewScoped
public class EmployeBean implements Serializable {

    private Employe employe;
    private Service service;
    private List<Employe> employes;
    private List<Employe> employesBetweenDates;
    private EmployeService employeService;
    private ServiceService serviceService;
    private static ChartModel barModel;
    private Date date1;
    private Date date2;
    private Employe selectedChef;

    public EmployeBean() {
        employe = new Employe();
        employe.setService(new Service());
        employeService = new EmployeService();
        serviceService = new ServiceService();
        selectedChef = new Employe();
    }

    public Employe getSelectedChef() {
        return selectedChef;
    }

    public void setSelectedChef(Employe selectedChef) {
        this.selectedChef = selectedChef;
    }

    public ServiceService getServiceService() {
        return serviceService;
    }

    public void setServiceService(ServiceService serviceService) {
        this.serviceService = serviceService;
    }

    public List<Employe> getEmployes() {
        if (employes == null) {
            employes = employeService.getAll();
        }
        return employes;
    }

    public void setEmployes(List<Employe> employes) {
        this.employes = employes;
    }

    public EmployeService getEmployeService() {
        return employeService;
    }

    public void setEmployeService(EmployeService employeService) {
        this.employeService = employeService;
    }

    public Employe getEmploye() {
        return employe;
    }

    public void setEmploye(Employe employe) {
        this.employe = employe;
    }

    public Date getDate1() {
        return date1;
    }

    public void setDate1(Date date1) {
        this.date1 = date1;
    }

    public Date getDate2() {
        return date2;
    }

    public void setDate2(Date date2) {
        this.date2 = date2;
    }

    public String onCreateAction() {
    employe.setChef(selectedChef);

    // Ajoutez le nouvel employé à la base de données ou à la source de données
    employeService.create(employe);

    // Rafraîchissez la liste des employés après l'ajout
    employes = employeService.getAll();

    // Réinitialisez l'employé pour le prochain ajout
    employe = new Employe();

    // Assurez-vous de retourner null ou une chaîne de navigation appropriée
    return null;
}


    public String onDeleteAction() {
        employeService.delete(employeService.getById((int) employe.getId()));
        return null;
    }

    public List<Employe> serviceLoad() {
        for (Employe e : employeService.getAll()) {
            if (e.getService().equals(service)) {
                employes.add(e);
            }
        }
        return employes;
    }

    public void load() {
        System.out.println(service.getNom());
        service = serviceService.getById((int) service.getId());
        getEmployes();
    }

    public void onEdit(RowEditEvent event) {
        Employe editedEmploye = (Employe) event.getObject();
        System.out.println("-----------------------------------------editedEmploye");
        System.out.println(editedEmploye.getId());
        System.out.println(editedEmploye.getNom());
        System.out.println(editedEmploye.getChef().getId());
        // Update service
        Service editedService = serviceService.getById((int) editedEmploye.getService().getId());
        editedEmploye.setService(editedService);

        // Update chef
        //  Employe editedChef = employeService.getById(editedEmploye.getChef().getId());
        //  editedEmploye.setChef(editedChef);

        employeService.update(editedEmploye);
    }

    public void onCancel(RowEditEvent event) {
    }

    public ChartModel getBarModel() {
        return barModel;
    }

    public ChartModel initBarModel() {
        // Code pour initialiser le modèle de graphique ici
        return barModel;
    }

    public List<Employe> employeLoad() {
        employesBetweenDates = employeService.getbydates(date1, date2);
        return null;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public List<Employe> getEmployesBetweenDates() {
        return employesBetweenDates;
    }

    public void setEmployesBetweenDates(List<Employe> employesBetweenDates) {
        this.employesBetweenDates = employesBetweenDates;
    }
}