package voting.web.presentation.presenters;

import java.util.List;

import voting.rest.business.controllers.BusinessControllerTheme;
import voting.web.presentation.models.Model;

public class ThemeManagerPresenter {

	public String process(Model model) {
		return "ThemeManagerView";
	}

	public List<Object> createTheme(String themeName) {
		BusinessControllerTheme businessController = new BusinessControllerTheme();
		businessController.createTheme(themeName);
		return businessController.listThemes();
	}
}
