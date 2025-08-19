package tp5.ejercicio1;

import java.util.List;

public interface Graph<T> {


	public Vertex<T> createVertex(T data);
	
		//Crea un vértice con el dato recibido y lo retorna.
	
	public void removeVertex(Vertex<T> vertex);
	
		//Elimina el vértice del grafo.
		//En caso de que el vértice esté relacionado con otros, estas relaciones 
		//también se eliminan.
	public Vertex<T> search(T data);
	
		//Busca y retorna el primer vértice cuyo dato es igual al parámetro recibido.
		//Retorna null si no existe tal.
	
	
	public void connect(Vertex<T> origin, Vertex<T> destination);
	
		//Conecta el vértice origen con el vértice destino.
		//Verifica que ambos vértices existan,Caso contrario no realiza 
		//ninguna conexión.
	
	
	public void connect(Vertex<T> origin, Vertex<T> destination, int weight);
	
		/*Conecta el vértice origen con el vértice destino con peso. Verifica que 
		 * ambos vértices existan, caso contrario no realiza ninguna conexión.
		 */
	
	
	
	public void disconnect(Vertex<T> origin, Vertex<T> destination);
	
		// Desconecta el vértice origen con el destino.
		/* Verifica que ambos vértices existan, caso contrario no realiza ninguna
		 * desconexión. En caso de existir la conexión destino-origen, esta
		 * permanecerá sin cambios.
		 */
	
	
	public boolean existsEdge(Vertex<T> origin, Vertex<T> destination);
	
		//Retorna true si existe una arista entre el vértice origen y el destino.
	
	
	
	public int weight(Vertex<T> origin, Vertex<T> destination);

		//Retorna el peso entre dos vértices.
		// En caso de no existir la arista retorna 0.
	
	
	
	public boolean isEmpty();
	
		//Retorna si el grafo no contiene datos(vértices creados)
	
	
	public List<Vertex<T>> getVertices();
		
	/**
	 * Retorna la lista de vértices.
	 * 
	 * @param v
	 * @return
	 */
	public List<Edge<T>> getEdges(Vertex<T> v);
	
		//Retorna la lista de adyacentes al vértice recibido.

	
	public Vertex<T> getVertex(int position);
	
	 	//Obtiene el vértice para la posición recibida.
	
	
	public int getSize();
		//Retorna la cantidad de vértices del grafo.

}
