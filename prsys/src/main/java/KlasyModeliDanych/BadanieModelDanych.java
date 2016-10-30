/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package KlasyModeliDanych;

import KlasyEncji.Historiabadan;
import KlasyEncji.Historialeczenia;
import KlasyEncji.Pacjent;
import KlasyUslug.UslugiCrud;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortMeta;
import org.primefaces.model.SortOrder;

/**
 *
 * @author JAzz
 */
public class BadanieModelDanych extends LazyDataModel<Historiabadan> {
    private List<Historiabadan> datasource;
    private int pageSize;
    private int rowIndex;
    private int rowCount;
    private UslugiCrud crudService;
    private Map filterMap;
    


   public BadanieModelDanych(UslugiCrud crudService, Map filterMap){
       this.crudService = crudService;
       this.filterMap = filterMap;
   }
   
   @Override
public List<Historiabadan> load(int first, int pageSize, List<SortMeta> multiSortMeta,
		Map<String, Object> filters) {
	   datasource = crudService.findWithNamedQuery("Historiabadan.findByFilters", filterMap);
       setRowCount(datasource.size());
       return datasource;
}
    
    /**
     * Checks if the row is available
     * @return boolean
     */
    @Override
    public boolean isRowAvailable() {
        if(datasource == null) 
            return false;
        int index = rowIndex % pageSize ; 
        return index >= 0 && index < datasource.size();
    }
    

    @Override
    public Object getRowKey(Historiabadan historiabadan) {
        System.out.print("ROW KEY :"+historiabadan.getId().toString());
        return historiabadan.getId().toString();
    }

 
    @Override
    public Historiabadan getRowData() {
        if(datasource == null)
            return null;
        int index =  rowIndex % pageSize;
        if(index > datasource.size()){
            return null;
        }
        return datasource.get(index);
    }
    

    @Override
    public Historiabadan getRowData(String rowKey) {
        if(datasource == null)
            return null;
       for(Historiabadan badania : datasource) {  
           if(badania.getId().toString().equals(rowKey))  
           return badania;  
       }  
       return null;  
    }
    
    

    @Override
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }


    @Override
    public int getPageSize() {
        return pageSize;
    }

    @Override
    public int getRowIndex() {
        return this.rowIndex;
    }
    
  
    @Override
    public void setRowIndex(int rowIndex) {
        this.rowIndex = rowIndex;
    }


    @Override
    public void setRowCount(int rowCount) {
        this.rowCount = rowCount;
    }
    
 
    @Override
    public int getRowCount() {
        return this.rowCount;
    }
     

    @Override
    public void setWrappedData(Object list) {
        this.datasource = (List<Historiabadan>) list;
    }
    
  
    @Override
    public Object getWrappedData() {
        return datasource;
    }
   private class LazySorter implements Comparator<Pacjent>{

         private String sortField;
    
    private SortOrder sortOrder;
    
    public LazySorter(String sortField, SortOrder sortOrder) {
        this.sortField = sortField;
        this.sortOrder = sortOrder;
    }

         public int compare(Pacjent pacjent1, Pacjent pacjent2) {
        try {
            Object value1 = Pacjent.class.getField(this.sortField).get(pacjent1);
            Object value2 = Pacjent.class.getField(this.sortField).get(pacjent2);

            int value = ((Comparable)value1).compareTo(value2);
            
            return SortOrder.ASCENDING.equals(sortOrder) ? value : -1 * value;
        }
        catch(Exception e) {
            throw new RuntimeException();
        }
    }
        
    }
}
