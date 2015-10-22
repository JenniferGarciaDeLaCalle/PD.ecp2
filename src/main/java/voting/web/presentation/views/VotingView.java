package voting.web.presentation.views;

import java.util.List;

import voting.rest.business.views.BusinessViewVote;
import voting.web.presentation.models.Model;

public class VotingView implements View {

	public String listAveragesToModel(Model model, List<Object> listAverages) {
		int id = 0;
		for (Object averages : listAverages) {
			model.put(id + "", averages);
			id++;
		}
		return "VotingView";
	}

	@Override
	public void show(Model model) {
		System.out.println("Voting Page ");
		System.out.print("   Temas: [");
		Object[] obj = model.getMap().values().toArray();
		for (int i = 0; i < obj.length; i++) {
			System.out.print("ThemeTransfer [themeName=" + ((BusinessViewVote) obj[i]).getTheme().getName()
					+ ", average=" + ((BusinessViewVote) obj[i]).getAverage() + "]");
			if (i < obj.length - 1) {
				System.out.print(", ");
			}
		}
		System.out.println("]");
	}

}