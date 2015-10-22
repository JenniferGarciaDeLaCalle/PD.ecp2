package voting.rest.business.views;

import voting.rest.business.models.entities.Theme;

public class BusinessViewVote {

	private Theme theme;

	private double average;

	public BusinessViewVote(Theme theme, String average) {
		this.theme = theme;
		this.average = Double.parseDouble(average);
	}

	public Theme getTheme() {
		return theme;
	}

	public double getAverage() {
		return average;
	}
}
