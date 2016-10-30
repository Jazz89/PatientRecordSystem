/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package KlasyModeliDanych;

import KlasyEncji.Specjalizacja;
import KlasyUslug.UslugiCrud;
import java.util.List;
import java.util.Map;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

/**
 *
 * @author JAzz
 */
public class SpecjalizacjaLazyDataModel extends LazyDataModel<Specjalizacja> {

	private List<Specjalizacja> datasource;
	private int pageSize;
	private int rowIndex;
	private int rowCount;
	private UslugiCrud crudService;
	private Map filterMap;

	/**
	 *
	 * @param crudService
	 */
	public SpecjalizacjaLazyDataModel(UslugiCrud crudService, Map filterMap) {
		this.filterMap = filterMap;
		this.crudService = crudService;
	}

	@Override
	public List<Specjalizacja> load(int first, int pageSize, String sortField, SortOrder sortOrder,
			Map<String, Object> filters) {
		datasource = crudService.findWithNamedQuery("Specjalizacja.findByFilters", filterMap);
		setRowCount(datasource.size());
		return datasource;
	}

	/**
	 * Checks if the row is available
	 *
	 * @return boolean
	 */
	@Override
	public boolean isRowAvailable() {
		if (datasource == null) {
			return false;
		}
		int index = rowIndex % pageSize;
		return index >= 0 && index < datasource.size();
	}

	@Override
	public Object getRowKey(Specjalizacja specjalizacja) {
		return specjalizacja.getId().toString();
	}

	@Override
	public Specjalizacja getRowData() {
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
	public Specjalizacja getRowData(String rowKey) {
		if (datasource == null) {
			return null;
		}
		for (Specjalizacja specjalizacja : datasource) {
			if (specjalizacja.getId().toString().equals(rowKey)) {
				return specjalizacja;
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
		this.datasource = (List<Specjalizacja>) list;
	}

	@Override
	public Object getWrappedData() {
		return datasource;
	}
}
