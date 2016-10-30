/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package KlasyModeliDanych;

import KlasyEncji.Pracownik;
import KlasyUslug.UslugiCrud;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

/**
 *
 * @author JAzz
 */
public class PracownikDataModel extends LazyDataModel<Pracownik> {

	private List<Pracownik> datasource;
	private int pageSize;
	private int rowIndex;
	private int rowCount;
	private UslugiCrud crudService;
	private Map filterMap;

	public PracownikDataModel(UslugiCrud crudService, Map filterMap) {
		this.filterMap = filterMap;
		this.crudService = crudService;
	}

	@Override
	public List<Pracownik> load(int first, int pageSize, String sortField, SortOrder sortOrder,
			Map<String, Object> filters) {
		if (filterMap.isEmpty()) {
			return null;
		} else {
			System.out.println("MAP: " + filterMap);
			datasource = crudService.findWithNamedQuery("Pracownik.findByFilters", filterMap);
			setRowCount(datasource.size());
			System.out.println("Row count: " + rowCount);
		}

		return datasource;
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
	public Object getRowKey(Pracownik Pracownik) {
		return Pracownik.getId().toString();
	}

	@Override
	public Pracownik getRowData() {
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
	public Pracownik getRowData(String rowKey) {
		if (datasource == null) {
			return null;
		}
		for (Pracownik Pracownik : datasource) {
			if (Pracownik.getId().toString().equals(rowKey)) {
				return Pracownik;
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
		this.datasource = (List<Pracownik>) list;
	}

	@Override
	public Object getWrappedData() {
		return datasource;
	}
}
