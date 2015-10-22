package voting.rest.business.controllers;

import java.util.ArrayList;
import java.util.List;

import voting.rest.business.models.entities.Theme;
import voting.rest.data.models.daos.DaoFactory;

public class BusinessControllerTheme {
	
	private static int idTheme = 0;
	
	public void createTheme(String themeName) {
		Theme theme = new Theme(idTheme, themeName);
		DaoFactory.getFactory().getThemeDao().create(theme);
		idTheme++;
	}

	public List<Object> listThemes() {
		List <Theme> listTheme = DaoFactory.getFactory().getThemeDao().findAll();
		List<Object> object = new ArrayList<Object>();
		for (Theme theme : listTheme) {
			object.add(theme);
		}
		return object;
	}

}
