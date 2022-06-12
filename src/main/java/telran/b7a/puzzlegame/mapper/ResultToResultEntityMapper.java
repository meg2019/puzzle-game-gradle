package telran.b7a.puzzlegame.mapper;

import org.mapstruct.Mapper;
import telran.b7a.puzzlegame.dao.ResultEntity;
import telran.b7a.puzzlegame.model.Result;

@Mapper(componentModel = "spring")
public interface ResultToResultEntityMapper {
    ResultEntity resultToResultEntityMapper(Result result);

    Result resultEntityToResultMapper(ResultEntity resultEntity);
}
