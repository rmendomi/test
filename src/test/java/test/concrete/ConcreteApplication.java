package test.concrete;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import com.accenture.concrete.client.IClienteCategorias;
import com.accenture.concrete.client.IClienteCupones;
import com.accenture.concrete.controller.ConcreteController;
import com.accenture.concrete.domain.Categories;
import com.accenture.concrete.domain.SubCategoriaN2;
import com.accenture.concrete.domain.SubCategoriaN3;
import com.accenture.concrete.domain.SubCategoriaN4;
import com.accenture.concrete.service.impl.ConcreteServiceImpl;

@RunWith(MockitoJUnitRunner.Silent.class)
public class ConcreteApplication {

	@InjectMocks
	private ConcreteServiceImpl concreteServiceImpl;

	@Mock
	private IClienteCupones iClienteCuponesMock;

	@Mock
	private IClienteCategorias iClienteCategoriasMock;

	@Mock
	ConcreteController concreteController;

	@Mock
	IClienteCategorias iClienteCategorias;

	String responseCoupons = new String();
	String responseCategory = new String();
	List<Categories> rsGetCategoriasOthers;
	List<Categories> rsGetCategorias;
	ResponseEntity<List<SubCategoriaN2>> lstSubCatn2Rs;
	List<SubCategoriaN2> assertOtherCategory;
	List<SubCategoriaN2> assertGetCategorias;

	@Before
	public void beforeGetCategorias() {

		assertGetCategorias = new ArrayList<>();
		List<SubCategoriaN3> lstCategoriaN3 = new ArrayList<>();
		List<SubCategoriaN4> lstCategoriaN4 = new ArrayList<>();

		SubCategoriaN2 subCategoriesN2 = new SubCategoriaN2();
		subCategoriesN2.setId("food");
		subCategoriesN2.setName("Food");
		subCategoriesN2.setRelevance(4);
		subCategoriesN2
				.setIconImageUrl("https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg");
		subCategoriesN2.setSubcategories(lstCategoriaN3);
		assertGetCategorias.add(subCategoriesN2);

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

		rsGetCategorias = new ArrayList<Categories>();

		Categories Categories = new Categories();
		Categories.setSubcategories(assertGetCategorias);
		Categories.setId("otros");
		Categories.setName("otros");
		Categories.setRelevance(0);
		rsGetCategorias.add(Categories);

	}

	@Before
	public void beforeOtherCategory() {

		assertOtherCategory = new ArrayList<>();
		List<SubCategoriaN3> lstCategorias1N3 = new ArrayList<>();
		List<SubCategoriaN4> lstCategorias1N4 = new ArrayList<>();
		SubCategoriaN4 subCategoria1N4 = new SubCategoriaN4();
		rsGetCategoriasOthers = new ArrayList<Categories>();

		
		Categories categorias = new Categories();
		categorias.setSubcategories(assertOtherCategory);
		categorias.setId("otros");
		categorias.setName("otros");
		categorias.setRelevance(0);
		rsGetCategoriasOthers.add(categorias);
		
		
		SubCategoriaN2 subcat1N2 = new SubCategoriaN2();
		subcat1N2.setId("food");
		subcat1N2.setName("Food");
		subcat1N2.setRelevance(4);
		subcat1N2
				.setIconImageUrl("https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg");
		subcat1N2.setSubcategories(lstCategorias1N3);
		assertOtherCategory.add(subcat1N2);

		SubCategoriaN3 subCategoriesN3 = new SubCategoriaN3();
		subCategoriesN3.setId("hamburger");
		subCategoriesN3.setName("Hamburger");
		subCategoriesN3.setRelevance(350);
		subCategoriesN3
				.setLargeImageUrl("https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg");
		subCategoriesN3
				.setSmallImageUrl("https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg");
		subCategoriesN3.setSubcategories(lstCategorias1N4);
		lstCategorias1N3.add(subCategoriesN3);

		
		lstCategorias1N4.add(subCategoria1N4);

		

		
		
		
		

	}

	@Test
	public void testGetCategorias() {
		Mockito.when(iClienteCategorias.getCategorias()).thenReturn(rsGetCategorias);

		List<SubCategoriaN2> retorno = concreteServiceImpl.getTopCategorias();

		assertEquals(retorno, assertGetCategorias);
	}

//	@Test
//	public void testOtherCategory() {
//		Mockito.when(iClienteCategorias.getCategorias()).thenReturn(rsGetCategoriasOthers);
//
//		List<SubCategoriaN2> retorno = concreteServiceImpl.getOthersCategorys();
//
//		assertEquals(retorno, assertOtherCategory);
//	}

}
