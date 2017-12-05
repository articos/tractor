package cz.unicorn.tga.tractor.dao;

        import cz.unicorn.tga.tractor.entity.Car;
        import cz.unicorn.tga.tractor.entity.Stk;
        import cz.unicorn.tga.tractor.model.enumeration.CarState;
        import org.springframework.data.jpa.repository.JpaRepository;
        import org.springframework.data.jpa.repository.Query;
        import org.springframework.data.repository.query.Param;

        import java.util.Date;
        import java.util.List;

public interface StkDAO extends JpaRepository<Stk, Long> {

    @Query("SELECT MAX(s.checkDate), c FROM Car c left join c.stks s WHERE " +
            " c.carState not in ( :notAllowcarStates) and (s is empty or s.checkDate <= :lastCheckDate) GROUP BY s.car")
    List<Object[]> findAllStkByCar(@Param("notAllowcarStates") List<CarState> notAllowcarStates,
                                   @Param("lastCheckDate")Date date);



    List<Stk> findAllByCar(Car car);

    @Query("SELECT MAX(s.checkDate), c.id, c.vin, c.carState FROM Stk s inner join s.car c " +
            "WHERE c.carState not in ( 'DISABLED', 'NEW')" +
            " GROUP BY s.car")
    List<Object[]> findStkAndCar();
}
