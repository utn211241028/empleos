package org.atziri.lopez.soriano.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.atziri.lopez.soriano.db.VacantesRepository;
import org.atziri.lopez.soriano.model.Categoria;
import org.atziri.lopez.soriano.model.Vacante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class VacantesServiceImp implements IntVacantes {
	
		@Autowired
		private VacantesRepository repoVacantes;
	//Agregar atributo
		private List<Vacante> lista = null;
		
		//Método Constructor
			public VacantesServiceImp() {
				lista = new LinkedList<Vacante>();
				DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				//Una instancia
				
				try {
				Vacante v1 = new Vacante();
				v1.setId(1);
				v1.setNombre("Desarrollo Web");
				v1.setDescripcion("Aplicaciones php");
				v1.setFecha(LocalDate.parse("07/06/2022", formato));
				v1.setSalario(304.70);
				v1.setEstatus("Creada");
				v1.setDestacado(1);
				v1.setImagen("logo8.png");
				v1.setDetalles("<h2>Ofrecemos</h2>"
						+ "<ul><li>Salario atractivo</li>"
						+ "<li>Oportunidad de desarrollo</li></ul>");
				Categoria cat1 = new Categoria();
				cat1.setId(4);
				cat1.setNombre("Programación");
				cat1.setDescripcion("");
				v1.setCategoria(cat1);
				//********************************************************
				Vacante v2 = new Vacante();
				v2.setId(2);
				v2.setNombre("Ingeniero en Telecomunicaciones");
				v2.setDescripcion("Conocimiento en redes");
				v2.setFecha(LocalDate.parse("16/11/2022", formato));
				v2.setSalario(500.50);
				v2.setEstatus("Creada");
				v2.setDestacado(1);
				v2.setImagen("logo8.png");
				v2.setDetalles("<h2>Ofrecemos</h2>"
						+ "<ul><li>Salario atractivo</li>"
						+ "<li>Oportunidad de desarrollo</li></ul>");
				Categoria cat2 = new Categoria();
				cat2.setId(2);
				cat2.setNombre("Tecnologías");
				cat2.setDescripcion("Descripción");
				v2.setCategoria(cat2);
				//***********************************************************
				Vacante v3 = new Vacante();
				v3.setId(3);
				v3.setNombre("Contador Público");
				v3.setDescripcion("Conocimiento en ACCESS");
				v3.setFecha(LocalDate.parse("24/04/2022", formato));
				v3.setSalario(708.90);
				v3.setEstatus("Creada");
				v3.setDestacado(1);
				v3.setImagen("logo8.png");
				v3.setDetalles("<h2>Ofrecemos</h2>"
						+ "<ul><li>Salario atractivo</li>"
						+ "<li>Oportunidad de desarrollo</li></ul>");
				Categoria cat3 = new Categoria();
				cat3.setId(5);
				cat3.setNombre("Contabilidad");
				cat3.setDescripcion("....");
				v3.setCategoria(cat3);
				
				lista.add(v1);
				lista.add(v2);
				lista.add(v3);
				}catch(DateTimeParseException ex) {
					System.out.println("Error: " + ex.getMessage());
				}
			}

		@Override
		public List<Vacante> obtenerTodas() {
			return repoVacantes.findAll();
		}

		@Override
		public void guardar(Vacante vacante) {
			repoVacantes.save(vacante);
		}

		@Override
		public void eliminar(Integer idVacante) {
			repoVacantes.deleteById(idVacante);
		}

		@Override
		public Vacante buscarPorId(Integer idVacante) {
			Optional<Vacante> optional = repoVacantes.findById(idVacante);
			if(optional.isPresent()) {
				return optional.get();
			}
			return null;
		}

		@Override
		public long numeroVacantes() {
			// TODO Auto-generated method stub
			return repoVacantes.count();
		}

		@Override
		public Page<Vacante> buscarTodas(Pageable page) {
			// TODO Auto-generated method stub
			return null;
		}

	}