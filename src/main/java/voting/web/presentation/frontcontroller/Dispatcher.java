package voting.web.presentation.frontcontroller;

import java.util.List;

import http.*;
import voting.web.presentation.models.Model;
import voting.web.presentation.presenters.ThemeManagerPresenter;
import voting.web.presentation.presenters.VotingPresenter;
import voting.web.presentation.views.ErrorView;
import voting.web.presentation.views.ThemeManagerView;
import voting.web.presentation.views.View;
import voting.web.presentation.views.VotingView;

public class Dispatcher {

	public void doGet(HttpRequest request, HttpResponse response) {

		Model model = new Model();
		String presenter = request.getPath() + "Presenter";
		String nextView = request.getPath() + "View";

		switch (presenter) {
		case "ThemeManagerPresenter":
			ThemeManagerPresenter themeManagerPresenter = new ThemeManagerPresenter();
			nextView = themeManagerPresenter.process(model);
			break;
		case "VotingPresenter":
			VotingPresenter votingPresenter = new VotingPresenter();
			nextView = votingPresenter.process(model);
			break;
		}
		this.show(nextView, model);

	}

	public void doPost(HttpRequest request, HttpResponse response) {

		Model model = new Model();
		String controller = request.getPath() + "Presenter";
		String action = request.getParams().get("action");
		String nextView = request.getPath() + "View";

		switch (controller) {
		case "ThemeManagerPresenter":
			ThemeManagerPresenter themeManagerPresenter = new ThemeManagerPresenter();
			if ("createTheme".equals(action)) {
				List<Object> object = themeManagerPresenter.createTheme(request.getParams().get("themeName"));

				nextView = new ThemeManagerView().listThemesToModel(model, object);
			} else {
				model.put("error", "Acción no permitida: " + action);
			}
			break;
		case "VotingPresenter":
			VotingPresenter votingPresenter = new VotingPresenter();
			if ("voteTheme".equals(action)) {
				List<Object> object = votingPresenter.voteTheme(request.getParams().get("themeName"),
						Integer.parseInt(request.getParams().get("value")));
				nextView = new VotingView().listAveragesToModel(model, object);
			} else {
				model.put("error", "Acción no permitida: " + action);
			}
			break;
		}
		this.show(nextView, model);

	}

	private void show(String nextView, Model model) {

		View view;
		switch (nextView) {
		case "ThemeManagerView":
			view = new ThemeManagerView();
			break;
		case "VotingView":
			view = new VotingView();
			break;
		default:
			view = new ErrorView();
			model.put("error", "Vista no encontrada: " + nextView);
		}
		view.show(model);

	}
}
