package br.com.monitoringDiabeticsApi.repository.helpers.doenca;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class DoencaRepositoryHelperImpl implements DoencaRepositoryHelper {

	@PersistenceContext
	private EntityManager manager;

	@Override
	public Long totalDoencasTipo1() {
		Optional<Long> doencaTipo1Optional = 
				Optional.ofNullable(this.manager.createQuery("select sum(d.codigo) from Doenca d", Long.class)
				.getSingleResult());
		return doencaTipo1Optional.orElse(new Long(1));
	}

	@Override
	public Long totalDoencasTipo2() {
		Optional<Long> doencaTipo2Optional = 
				Optional.ofNullable(this.manager.createQuery("select sum(d.codigo) from Doenca d", Long.class)
				.getSingleResult());
		return doencaTipo2Optional.orElse(new Long(1));
	}

	@Override
	public Long totalDoencasGestacional() {
		Optional<Long> doencaGestacionalOptional = 
				Optional.ofNullable(this.manager.createQuery("select sum(d.codigo) from Doenca d", Long.class)
				.getSingleResult());
		return doencaGestacionalOptional.orElse(new Long(1));
	}

	@Override
	public Long totalDoencasLada() {
		Optional<Long> doencaLadaOptional = 
				Optional.ofNullable(this.manager.createQuery("select sum(d.codigo) from Doenca d", Long.class)
				.getSingleResult());
		return doencaLadaOptional.orElse(new Long(1));
	}
}
