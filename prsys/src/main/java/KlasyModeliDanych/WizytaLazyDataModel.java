/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package KlasyModeliDanych;

import KlasyEncji.Wizyta;
import KlasyUslug.UslugiCrud;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

/**
 *
 * @author JAzz
 */
public class WizytaLazyDataModel extends LazyDataModel<Wizyta>implements Serializable {

	private List<Wizyta> datasource;
	private int pageSize;
	private int rowIndex;
	private int rowCount;
	private UslugiCrud crudService;
	private Map filterMap;

	public WizytaLazyDataModel(UslugiCrud crudService, Map filterMap) {
		this.crudService = crudService;
		this.filterMap = filterMap;
	}

	@Override
	public List<Wizyta> load(int first, int pageSize, String sortField, SortOrder sortOrder,
			Map<String, Object> filters) {
		if (filterMap.isEmpty()) {
			return null;
		} else {
			datasource = crudService.findWithNamedQuery("Wizyta.findByFilters", filterMap);
			setRowCount(datasource.size());
			return datasource;
		}
	}

	/**
	 * Checks if the row is available
	 * 
	 * @return boolean
	 */
	@Override
	public boolean isRowAvailable() {
		if (datasource == null)
			return false;
		int index = rowIndex % pageSize;
		return index >= 0 && index < datasource.size();
	}

	@Override
	public Object getRowKey(Wizyta Wizyta) {
		return Wizyta.getId().toString();
	}

	@Override
	public Wizyta getRowData() {
		if (datasource == null)
			return null;
		int index = rowIndex % pageSize;
		if (index > datasource.size()) {
			return null;
		}
		return datasource.get(index);
	}

	@Override
	public Wizyta getRowData(String rowKey) {
		if (datasource == null)
			return null;
		for (Wizyta badania : datasource) {
			if (badania.getId().toString().equals(rowKey))
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
		this.datasource = (List<Wizyta>) list;
	}

}
