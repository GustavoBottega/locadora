package model.bean;

public class Cliente {
	
		private int idCliente;
		private String Nome;
		private int idade;
		private String email;
		private String estadocivil;
		public int getIdCliente() {
			return idCliente;
		}
		public void setIdCliente(int idCliente) {
			this.idCliente = idCliente;
		}
		public String getNome() {
			return Nome;
		}
		public void setNome(String nome) {
			Nome = nome;
		}
		public int getIdade() {
			return idade;
		}
		public void setIdade(int idade) {
			this.idade = idade;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getEstadocivil() {
			return estadocivil;
		}
		public void setEstadocivil(String estadocivil) {
			this.estadocivil = estadocivil;
		}
		
		
		
}
