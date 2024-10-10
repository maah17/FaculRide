'use strict';
const {
  Model
} = require('sequelize');
module.exports = (sequelize, DataTypes) => {
  class rotas extends Model {
    /**
     * Helper method for defining associations.
     * This method is not a part of Sequelize lifecycle.
     * The `models/index` file will call this method automatically.
     */
    static associate(models) {
      // define association here
    }
  }
  rotas.init({
    ponto_partida: DataTypes.STRING,
    ponto_chegada: DataTypes.STRING,
    data: DataTypes.STRING,
    cordenadas: DataTypes.STRING
  }, {
    sequelize,
    modelName: 'rotas',
    tableName: 'rotas'
  });
  return rotas;
};