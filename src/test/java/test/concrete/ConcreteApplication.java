package test.concrete;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.powermock.api.mockito.PowerMockito;
import org.springframework.http.ResponseEntity;

import com.accenture.concrete.client.IClienteCategorias;
import com.accenture.concrete.client.IClienteCupones;
import com.accenture.concrete.controller.ConcreteController;
import com.accenture.concrete.domain.Categories;
import com.accenture.concrete.domain.SubCategoriaN2;
import com.accenture.concrete.domain.SubCategoriaN3;
import com.accenture.concrete.domain.SubCategoriaN4;
import com.accenture.concrete.service.impl.ConcreteServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class ConcreteApplication {

	@InjectMocks
	private ConcreteServiceImpl concreteServiceImpl;

	@Mock
	private IClienteCupones iClienteCuponesMock;

	@Mock
	private IClienteCategorias iClienteCategoriasMock;

	String responseCoupons = new String();

	String responseCategory = new String();

	List<Categories> categoriasRs;

	ResponseEntity<List<SubCategoriaN2>> lstSubCatn2Rs;

	List<SubCategoriaN2> rsgetTopCategorias;

	@Mock
	ConcreteController concreteController;

	@Mock
	IClienteCategorias iClienteCategorias;

	@Before
	public void init() {
	
		rsgetTopCategorias = new ArrayList<>();

		List<SubCategoriaN3> lstCategoriaN3 = new ArrayList<>();

		List<SubCategoriaN4> lstCategoriaN4 = new ArrayList<>();

		SubCategoriaN2 subCategoriesN2 = new SubCategoriaN2();
		subCategoriesN2.setId("food");
		subCategoriesN2.setName("Food");
		subCategoriesN2.setRelevance(4);
		subCategoriesN2
				.setIconImageUrl("https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg");
		subCategoriesN2.setSubcategories(lstCategoriaN3);
		rsgetTopCategorias.add(subCategoriesN2);

		SubCategoriaN3 subCategoriesN3 = new SubCategoriaN3();
		subCategoriesN3.setId("hamburger");
		subCategoriesN3.setName("Hamburger");
		subCategoriesN3.setRelevance(350);
		subCategoriesN3
				.setLargeImageUrl("https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg");
		subCategoriesN3
				.setSmallImageUrl("https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg");
		subCategoriesN3.setSubcategories(lstCategoriaN4);
		lstCategoriaN3.add(subCategoriesN3);

		SubCategoriaN4 subCategoriaN4 = new SubCategoriaN4();
		lstCategoriaN4.add(subCategoriaN4);

		categoriasRs = new ArrayList<Categories>();
//		List<Categories> lstCategories = new ArrayList<>();
		Categories Categories = new Categories();
		Categories.setSubcategories(rsgetTopCategorias);
		categoriasRs.add(Categories);

	}

	@Test
	public void testGetCategorias() {
		PowerMockito.when(iClienteCategorias.getCategorias()).thenReturn(categoriasRs);

		List<SubCategoriaN2> retorno = concreteServiceImpl.getTopCategorias();

		assertEquals(retorno, rsgetTopCategorias);
	}

}
