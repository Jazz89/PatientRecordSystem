
package KlasyModeliDanych;

import KlasyEncji.Pacjent;
import KlasyUslug.UslugiCrud;
import Util.LazySorter;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

/**
 *
 * @author JAzz
 */
public class PacjentDataModel extends LazyDataModel<Pacjent> {

    private List<Pacjent> datasource;
    private int pageSize;
    private int rowIndex;
    private int rowCount;
    private UslugiCrud crudService;
    private Map filterMap;

    public PacjentDataModel(UslugiCrud crudService, Map filterMap) {
        this.filterMap = filterMap;
        this.crudService = crudService;
    }


    @Override
    public List<Pacjent> load(int first, int pageSize, String sortField, SortOrder sortOrder,
    		Map<String, Object> filters) {
    	// TODO Auto-generated method stub
    	 if (filterMap.isEmpty()) {
             return null;
         } else {
             
             datasource = crudService.findWithNamedQuery("Pacjent.findByFilters", filterMap);
             setRowCount(datasource.size());
             System.out.println("Row count: "+rowCount);
        

         return datasource; 
         }
    }
    
    @Override
    public boolean isRowAvailable() {
        if (datasource == null) {
            return false;
        }
        int index = rowIndex % pageSize;
        return index >= 0 && index < datasource.size();
    }

    @Override
    public Object getRowKey(Pacjent Pacjent) {
        return Pacjent.getId().toString();
    }

    @Override
    public Pacjent getRowData() {
        if (datasource == null) {
            return null;
        }
        int index = rowIndex % pageSize;
        if (index > datasource.size()) {
            return null;
        }
        return datasource.get(index);
    }

    @Override
    public Pacjent getRowData(String rowKey) {
        if (datasource == null) {
            return null;
        }
        for (Pacjent Pacjent : datasource) {
            if (Pacjent.getId().toString().equals(rowKey)) {
                return Pacjent;
            }
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
        this.datasource = (List<Pacjent>) list;
    }

    @Override
    public Object getWrappedData() {
        return datasource;
    }


}
