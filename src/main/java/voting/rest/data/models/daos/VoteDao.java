package voting.rest.data.models.daos;

import java.util.List;

import voting.rest.business.models.entities.Theme;
import voting.rest.business.models.entities.Vote;

public interface VoteDao extends GenericDao<Vote, Integer> {

	List<Vote> findByTheme(Theme theme);
}
