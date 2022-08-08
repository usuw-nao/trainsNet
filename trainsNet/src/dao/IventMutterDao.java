package dao;

import java.util.List;

import domain.IventMutter;

public interface IventMutterDao {
	List<IventMutter> findAll() throws Exception;

	void insert(IventMutter iventMutter) throws Exception;

	void updated(IventMutter iventMutter) throws Exception;

	void delete(IventMutter iventMutter) throws Exception;

}