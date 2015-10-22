package voting.rest.business.controllers;

import java.util.ArrayList;
import java.util.List;

import voting.rest.business.models.entities.Theme;
import voting.rest.business.models.entities.Vote;
import voting.rest.business.views.BusinessViewVote;
import voting.rest.data.models.daos.DaoFactory;

public class BusinessControllerVote {

	private static int idVote = 0;

	public void voteTheme(String themeName, int value) {
		Theme theme = DaoFactory.getFactory().getThemeDao().findByName(themeName);
		Vote vote = new Vote(idVote, value, theme);
		DaoFactory.getFactory().getVoteDao().create(vote);
		idVote++;
	}

	public List<Object> listAverage() {
		List<Theme> listThemes = DaoFactory.getFactory().getThemeDao().findAll();
		List<Vote> listVotes = DaoFactory.getFactory().getVoteDao().findAll();
		List<Object> listAverages = new ArrayList<Object>();

		for (int i = 0; i < listThemes.size(); i++) {
			double puntuacionTotal = 0;
			for (int j = 0; j < listVotes.size(); j++) {
				if (listVotes.get(j).getTheme().getName().equals(listThemes.get(i).getName())) {
					if (puntuacionTotal != 0) {
						puntuacionTotal += listVotes.get(j).getVote();
						puntuacionTotal /= 2;
					} else {
						puntuacionTotal += listVotes.get(j).getVote();
					}
				}
			}
			listAverages.add(new BusinessViewVote(listThemes.get(i), Double.toString(puntuacionTotal)));
		}
		return listAverages;
	}
}
