package voting.web.presentation.views;

import java.util.List;

import voting.rest.business.models.entities.Theme;
import voting.web.presentation.models.Model;

public class ThemeManagerView implements View {

	public String listThemesToModel(Model model, List<Object> listThemes) {
		for (Object theme : listThemes) {
			model.put(((Theme) theme).getName(), theme);
		}
		return "ThemeManagerView";
	}

	@Override
	public void show(Model model) {
		System.out.println("Theme Manager Page");
		System.out.print("   Temas: [");
		Object[] keys = model.getMap().keySet().toArray();
		for (int i = keys.length - 1; i >= 0; i--) {
			System.out.print(keys[i]);
			if (i > 0) {
				System.out.print(", ");
			}
		}
		System.out.println("]");
	}

}