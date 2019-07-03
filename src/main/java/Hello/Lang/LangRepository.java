package Hello.Lang;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LangRepository extends JpaRepository<Lang, Integer> {
// <Klasa z której czerpię, typ ID>

    List<Lang> findByCode(String code); //to już zadziała i będzie znajdować po kodzie

    // findAll jest już w JpaRepository


}
