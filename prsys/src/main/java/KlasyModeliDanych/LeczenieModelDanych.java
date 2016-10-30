/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package KlasyModeliDanych;

import KlasyEncji.Historialeczenia;
import KlasyEncji.Pacjent;
import KlasyUslug.UslugiCrud;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

/**
 *
 * @author JAzz
 */
public class LeczenieModelDanych extends LazyDataModel<Historialeczenia> {

	private List<Historialeczenia> datasource;
	private Pacjent pacjent;
	private int pageSize;
	private int rowIndex;
	private int rowCount;
	private UslugiCrud crudService;
	private Map filterMap;

	public LeczenieModelDanych(UslugiCrud crudService, Map filterMap) {
		this.crudService = crudService;
		this.filterMap = filterMap;
	}

	@Override
	public List<Historialeczenia> load(int first, int pageSize, String sortField, SortOrder sortOrder,
			Map<String, Object> filters) {
		System.out.println(filterMap);
		datasource = crudService.findWithNamedQuery("Historialeczenia.findByFilters", filterMap);
		System.out.println(datasource);
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
		if (datasource == null)
			return false;
		int index = rowIndex % pageSize;
		return index >= 0 && index < datasource.size();
	}

	@Override
	public Object getRowKey(Historialeczenia Historialeczenia) {
		System.out.print("ROW KEY :" + Historialeczenia.getId().toString());
		return Historialeczenia.getId().toString();
	}

	@Override
	public Historialeczenia getRowData() {
		if (datasource == null)
			return null;
		int index = rowIndex % pageSize;
		if (index > datasource.size()) {
			return null;
		}
		return datasource.get(index);
	}

	@Override
	public Historialeczenia getRowData(String rowKey) {
		if (datasource == null)
			return null;
		for (Historialeczenia leczenia : datasource) {
			if (leczenia.getId().toString().equals(rowKey))
				return leczenia;
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
		this.datasource = (List<Historialeczenia>) list;
	}

	@Override
	public Object getWrappedData() {
		return datasource;
	}

}
/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
