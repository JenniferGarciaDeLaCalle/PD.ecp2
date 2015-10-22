package voting.web.presentation.presenters;

import java.util.List;

import voting.rest.business.controllers.BusinessControllerVote;
import voting.web.presentation.models.Model;

public class VotingPresenter {

	public String process(Model model) {
		return "VotingView";
	}

	public List<Object> voteTheme(String themeName, int value) {
		BusinessControllerVote businessController = new BusinessControllerVote();
		businessController.voteTheme(themeName, value);
		return businessController.listAverage();
	}

}
